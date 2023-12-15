package com.inventoryxpert.application.views.Invoicing;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Route("invoice")
public class AddInvoice extends VerticalLayout {

   private CustomerService customerService;

   private TextField invoiceNumberField; // Declare the TextField here

   // Method to generate a unique invoice number
   private String generateInvoiceNumber() {
      // This is a very basic example. You might want to implement a more complex
      // logic
      // to generate a unique invoice number based on your requirements.
      return "INV-" + System.currentTimeMillis();
   }

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

      // Create the TextField and set its value to the generated invoice number
      // TextField invoiceNumberField = new TextField("Invoice Number");
      // invoiceNumberField.setValue(generateInvoiceNumber());

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

      invoiceNumberField = new TextField("Invoice Number");
      invoiceNumberField.setValue(generateInvoiceNumber());

      formLayout.add(
            customerNameField,
            customerAddressField,
            emailAddressField,
            tinField,
            invoiceNumberField, // Use the auto-generated invoice number field
            new TextField("Terms of Payments"),
            new DatePicker("Date of Make"),
            new DatePicker("Expiry Date"),
            contactPersonField,
            new TextField("Taxes"));

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

   @Override
   protected void onAttach(AttachEvent attachEvent) {
      super.onAttach(attachEvent);
   }
}