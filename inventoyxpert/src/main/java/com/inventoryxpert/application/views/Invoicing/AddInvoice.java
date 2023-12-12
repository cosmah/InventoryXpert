package com.inventoryxpert.application.views.Invoicing;

import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.service.InvoiceService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Route("create-invoice")
public class AddInvoice extends VerticalLayout {

    private final Invoice invoice;
  
    @Autowired
    private InvoiceService invoiceService;
  
    public AddInvoice() {
        this.invoice = new Invoice();
       this.invoice = invoice;

       // Format currency for display (replace with your preferred format)
       DecimalFormat currencyFormatter = new DecimalFormat("#,###.00");

       // Invoice Header Components
       Label invoiceNumberLabel = new Label("Invoice Number: " + invoice.getInvoiceNumber());
       Label customerNameLabel = new Label("Customer Name: " + invoice.getCustomerName());
       Label invoiceDateLabel = new Label("Invoice Date: " + invoice.getInvoiceDate());
       Label expiryDateLabel = new Label("Expiry Date: " + invoice.getExpiryDate());

       // Invoice Lines Grid
       Grid<InvoiceLine> lineItemTable = new Grid<>();
       lineItemTable.setSizeFull(); // adjust size as needed
       lineItemTable.addColumn(InvoiceLine::getProductName).setHeader("Product Name");
       lineItemTable.addColumn(InvoiceLine::getProductDescription).setHeader("Description");
       lineItemTable.addColumn(InvoiceLine::getQuantity).setHeader("Quantity");
       lineItemTable.addColumn(invoiceLine -> currencyFormatter.format(invoiceLine.getUnitPrice())).setHeader("Unit Price");
       lineItemTable.addColumn(invoiceLine -> currencyFormatter.format(invoiceLine.getQuantity() * invoiceLine.getUnitPrice())).setHeader("Total Price");
       lineItemTable.setItems(invoice.getInvoiceLines());

       // Calculate and format tax (replace with your logic)
       double taxAmount = 0.0; // replace with actual calculation
       Label taxLabel = new Label("Tax: " + currencyFormatter.format(taxAmount));

       // Invoice Totals
       double totalSales = invoice.getTotalSales();
       Label subtotalLabel = new Label("Subtotal: " + currencyFormatter.format(totalSales));
       Label totalLabel = new Label("Total: " + currencyFormatter.format(totalSales + taxAmount));

       // Add all components to layout
       addComponents(invoiceNumberLabel, customerNameLabel, invoiceDateLabel, expiryDateLabel, lineItemTable, subtotalLabel, taxLabel, totalLabel);
   }
}
