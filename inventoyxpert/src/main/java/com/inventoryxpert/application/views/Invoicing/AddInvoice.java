package com.inventoryxpert.application.views.Invoicing;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.entity.Term;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.backend.service.TermsService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Add Invoice")
@Route("invoice")
public class AddInvoice extends VerticalLayout {

   private CustomerService customerService;
   private TermsService termofPaymentService;
   private DatePicker dateOfMakeField;
   private DatePicker expiryDateField;

   private TextField invoiceNumberField; // Declare the TextField here

   // Class to store the last used sequence number
   public class SequenceNumber {
      private static int lastNumber = 0;

      public static synchronized int getNextNumber() {
         lastNumber++;
         return lastNumber;
      }
   }

   // Method to generate a unique invoice number
   private String generateInvoiceNumber() {
      // Get the current date
      LocalDate currentDate = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

      // Get the next sequence number
      int sequenceNum = SequenceNumber.getNextNumber();

      // Construct the invoice number
      return currentDate.format(formatter) + String.format("%04d", sequenceNum);
   }

   @Autowired
   public AddInvoice(CustomerService customerService, TermsService termofPaymentService) {
      this.customerService = customerService;
      this.termofPaymentService = termofPaymentService;

      setSizeFull();
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

      invoiceNumberField = new TextField("Invoice Number");
      invoiceNumberField.setValue(generateInvoiceNumber());

      // Fetch terms and set them as the items of the ComboBox
      ComboBox<Term> termsOfPaymentField = new ComboBox<>("Terms of Payment");
      Collection<Term> terms = termofPaymentService.getAllTerms();
      termsOfPaymentField.setItems(terms);
      termsOfPaymentField.setItemLabelGenerator(Term::getTermsName);
      
      formLayout.add(
            customerNameField,
            customerAddressField,
            emailAddressField,
            tinField,
            invoiceNumberField, // Use the auto-generated invoice number field
            termsOfPaymentField,
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