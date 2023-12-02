package com.inventoryxpert.application.views.people.customers;

import org.springframework.beans.factory.annotation.Autowired;
import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Add Customer")
@Route(value = "Customer", layout = MainLayout.class)
public class AddCustomer extends VerticalLayout {

   
    private final CustomerService customerService;

    @Autowired
    public AddCustomer(CustomerService customerService) {
        this.customerService = customerService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField nameField = new TextField("Customer Name");
        TextField addressField = new TextField("Customer Address");
        TextField phoneField = new TextField("Customer Phone");
        TextField emailField = new TextField("Customer Email");
        TextField contactPersonField = new TextField("Customer Contact Person");
        TextField tinField = new TextField("Customer Tin");

        Button button = new Button("Add Customer");
        formLayout.add(nameField, addressField, phoneField, emailField, contactPersonField, tinField, button);

        button.addClickListener(e -> {
            Customer customer =customerService.save(null,
                    nameField.getValue(), addressField.getValue(), phoneField.getValue(),
                    emailField.getValue(), contactPersonField.getValue(), Integer.parseInt(tinField.getValue()));
        
            if (customer != null) {
                Notification.show("Product Added");
            }else{
                Notification.show("Failed to add product");
            }

            nameField.clear();
            addressField.clear();
            phoneField.clear();
            emailField.clear();
            contactPersonField.clear();
            tinField.clear();
                    
        
        });



        add(formLayout);
    }

   
}