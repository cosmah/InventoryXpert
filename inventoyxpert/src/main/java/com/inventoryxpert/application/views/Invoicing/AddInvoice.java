package com.inventoryxpert.application.views.Invoicing;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("invoice")
public class AddInvoice extends VerticalLayout {
   public AddInvoice() {
      FormLayout formLayout = new FormLayout();
      formLayout.add(
              new TextField("Customer Name"),
              new TextField("Customer Address"),
              new TextField("Email Address"),
              new TextField("TIN"),
              new TextField("Invoice Number"),
              new TextField("Terms of Payments"),
              new DatePicker("Date of Make"),
              new DatePicker("Expiry Date"),
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
