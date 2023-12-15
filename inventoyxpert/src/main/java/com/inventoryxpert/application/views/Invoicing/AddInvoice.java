package com.inventoryxpert.application.views.Invoicing;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Route("invoice")
public class AddInvoice extends VerticalLayout {

   private CustomerService customerService;

@Autowired
public AddInvoice(CustomerService customerService) {
    this.customerService = customerService;
    FormLayout formLayout = new FormLayout();

    List<String> customerNames = customerService.getAllCustomerNames();

    ComboBox<String> customerNameField = new ComboBox<>("Customer Name");
    customerNameField.setItems(customerNames);
    customerNameField.setAllowCustomValue(true);

    TextField customerAddressField = new TextField("Customer Address");
    TextField emailAddressField = new TextField("Email Address");
    TextField tinField = new TextField("TIN");
    TextField contactPersonField = new TextField("Contact Person");

    customerNameField.addCustomValueSetListener(event -> {
        String enteredName = event.getDetail();
        if (!customerNames.contains(enteredName)) {
            customerNameField.clear();
            customerNameField.setItems("Add Customer");
        }
    });

    customerNameField.addValueChangeListener(event -> {
        String selectedCustomerName = event.getValue();
        if ("Add Customer".equals(selectedCustomerName)) {
            UI.getCurrent().navigate("Customer");
        } else if (selectedCustomerName != null) {
            Customer selectedCustomer = customerService.getCustomerByCustomerName(selectedCustomerName);
            if (selectedCustomer != null) {
                customerAddressField.setValue(selectedCustomer.getCustomerAddress());
                emailAddressField.setValue(selectedCustomer.getCustomerEmail());
                tinField.setValue(String.valueOf(selectedCustomer.getCustomerTin()));
                contactPersonField.setValue(selectedCustomer.getCustomerContactPerson().getEmployeeName());
            }
        }
    });

    formLayout.add(
        customerNameField,
        customerAddressField,
        emailAddressField,
        tinField,
        new TextField("Invoice Number"),
        new TextField("Terms of Payments"),
        new DatePicker("Date of Make"),
        new DatePicker("Expiry Date"),
        contactPersonField,
        new TextField("Taxes")
    );

    add(formLayout);

    Grid<InvoiceLine> grid = new Grid<>(InvoiceLine.class);
    grid.setColumns("productName", "productCode", "productDescription", "quantity", "unitPrice", "totalPrice");
    add(grid);

    TextField totalAmount = new TextField("Total Amount");
    totalAmount.setReadOnly(true);
    add(totalAmount);

    Button saveButton = new Button("Save Invoice", event -> {
        // Save the invoice here
    });
    add(saveButton);
}
}