package com.inventoryxpert.application.views.Invoicing;

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
      customerNameField.setItems(customerNames);
      customerNameField.setAllowCustomValue(true);
      customerNameField.addCustomValueSetListener(event -> {
         String enteredName = event.getDetail();
         if (!customerNames.contains(enteredName)) {
            customerNameField.clear();
            customerNameField.setItems("Add Customer");
         }
      });
      customerNameField.addValueChangeListener(event -> {
         if ("Add Customer".equals(event.getValue())) {
            UI.getCurrent().navigate("Customer");
         }
      });

      formLayout.add(
            customerNameField,
            new TextField("Customer Address"),
            new TextField("Email Address"),
            new TextField("TIN"),
            new TextField("Invoice Number"),
            new TextField("Terms of Payments"),
            new DatePicker("Date of Make"),
            new DatePicker("Expiry Date"),
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

   private void addNewCustomer(String customerName) {
      // Navigate to the AddCustomer view
      UI.getCurrent().navigate("Customer");
   }
}