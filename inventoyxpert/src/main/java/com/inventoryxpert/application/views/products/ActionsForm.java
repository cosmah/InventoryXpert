package com.inventoryxpert.application.views.products;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.service.ProductService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ActionsForm extends FormLayout {

        TextField nameField = new TextField("Product Name");
        TextField codeField = new TextField("Product Code");
        TextField descriptionField = new TextField("Product Description");
        TextField quantityField = new TextField("Quantity");
        TextField priceField = new TextField("Price");
        TextField resalePriceField = new TextField("Resale price");
        TextField supplierField = new TextField("Supplier");
        DatePicker startingDateField = new DatePicker("Starting Date");

        Button save = new Button("Save");
        Button delete = new Button("Delete");
        Button close = new Button("Cancel");

        public ActionsForm(){
            addClassName("product-form");
            add(nameField, codeField,descriptionField, quantityField,priceField,
                    resalePriceField,supplierField,startingDateField,
                    createButtonsLayout());
        }

    private HorizontalLayout createButtonsLayout() {
            save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            save.addThemeVariants(ButtonVariant.LUMO_ERROR);
            save.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

            save.addClickShortcut(Key.ENTER);
            close.addClickShortcut(Key.ESCAPE);

            return new HorizontalLayout(save, delete,close);
    }


}
