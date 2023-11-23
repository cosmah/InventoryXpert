package com.inventoryxpert.application.views.products;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.service.InvoiceService;
import com.inventoryxpert.application.backend.service.ProductService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Add Product")
@Route(value = "Invoice", layout = MainLayout.class)
public class ProductView extends VerticalLayout{

    private final ProductService productService;

    @Autowired
    public ProductView(ProductService productService){
        this.productService = productService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField nameField = new TextField("Product Name");
        TextField codeField = new TextField("Product Code");
        TextField descriptionField = new TextField("Product Description");
        TextField quantityField = new TextField("Quantity");
        TextField priceField = new TextField("Price");
        TextField supplierField = new TextField("Supplier");
        DatePicker startingDateField = new DatePicker("Starting Date");

        Button button = new Button("Add Product");
        formLayout.add(nameField, codeField,descriptionField,
        quantityField,priceField,priceField,supplierField,startingDateField);

        button.addClickListener(e -> {
            Date date = java.sql.Date.valueOf(startingDateField.getValue());

            Product product = productService.save(null,
                nameField.getValue(), codeField.getValue(), descriptionField.getValue(),
                quantityField.getValue(),
                priceField.getValue(),
                    date
                , supplierField.getValue());

            if (product != null) {
                Notification.show("Product Added");
            }else{
                Notification.show("Failed to add product");
            }

            nameField.clear();
            codeField.clear();
            descriptionField.clear();
            quantityField.clear();
            priceField.clear();
            supplierField.clear();
            startingDateField.clear();
            
        });

        add(formLayout);
        
    }
    
}
