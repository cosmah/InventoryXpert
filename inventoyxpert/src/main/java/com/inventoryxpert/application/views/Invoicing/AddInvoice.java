package com.inventoryxpert.application.views.Invoicing;

import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.service.InvoiceService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@PageTitle("Add Invoice")
@Route(value = "Invoice", layout = MainLayout.class)
public class AddInvoice extends HorizontalLayout {

    private final InvoiceService invoiceService;

    @Autowired
    public AddInvoice(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField invoiceNumberField = new TextField("Invoice Number");
        DatePicker invoiceDatePicker = new DatePicker("Invoice Date");
        TextField customerNameField = new TextField("Customer Name");
        TextField customerAddressField = new TextField("Customer Address");
        TextField totalAmountField = new TextField("Total Amount");
        TextField paymentTermsField = new TextField("Terms");
        Button addButton = new Button("Add Invoice");
        formLayout.add(invoiceNumberField, invoiceDatePicker, customerNameField, customerAddressField,totalAmountField,paymentTermsField, addButton);

        addButton.addClickListener(e -> {
            // Convert LocalDate to java.util.Date
            Date date = java.sql.Date.valueOf(invoiceDatePicker.getValue());

            // Convert the total amount from String to double
            Double totalAmount = null;
            try {
                totalAmount = Double.parseDouble(totalAmountField.getValue());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            // Call the save method with the appropriate parameters
            Invoice invoice = invoiceService.save(
                    null, invoiceNumberField.getValue(),
                    date, customerNameField.getValue(),
                    customerAddressField.getValue(), totalAmount,
                    paymentTermsField.getValue());

            if (invoice != null) {
                Notification.show("Invoice added successfully!");
            } else {
                Notification.show("Failed to add invoice.");
            }

            invoiceDatePicker.clear();
            invoiceNumberField.clear();
            customerAddressField.clear();
            customerNameField.clear();
            totalAmountField.clear();
            paymentTermsField.clear();
        });

        add(formLayout);
    }
}
