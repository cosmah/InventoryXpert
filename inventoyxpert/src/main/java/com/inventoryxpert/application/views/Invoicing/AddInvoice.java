package com.inventoryxpert.application.views.Invoicing;

        import com.inventoryxpert.application.backend.entity.Invoice;
        import com.inventoryxpert.application.backend.service.InvoiceService;
        import com.inventoryxpert.application.views.MainLayout;
        import com.vaadin.flow.component.Key;
        import com.vaadin.flow.component.button.Button;
        import com.vaadin.flow.component.formlayout.FormLayout;
        import com.vaadin.flow.component.notification.Notification;
        import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
        import com.vaadin.flow.component.textfield.TextField;
        import com.vaadin.flow.router.PageTitle;
        import com.vaadin.flow.router.Route;
        import org.springframework.beans.factory.annotation.Autowired;

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
        TextField invoiceDateField = new TextField("Invoice Date");
        TextField customerNameField = new TextField("Customer Name");
        TextField customerAddressField = new TextField("Customer Address");
        TextField totalAmountField = new TextField("Total Amount");
        TextField paymentTermsField = new TextField("Terms");
        Button addButton = new Button("Add Invoice");
        formLayout.add(invoiceNumberField, invoiceDateField, customerNameField, customerAddressField,totalAmountField,paymentTermsField, addButton);

        addButton.addClickListener(e -> {
            Invoice invoice = new Invoice();
            invoice.setInvoiceNumber(invoiceNumberField.getValue());
            invoice.setInvoiceDate(invoiceDateField.getValue());
            invoice.setCustomerName(customerNameField.getValue());
            invoice.setCustomerAddress(customerAddressField.getValue());
            invoice.setTotalAmount(totalAmountField.getValue());
            invoice.setPaymentTerms(paymentTermsField.getValue());

            invoiceService.save(invoice);
            invoiceDateField.clear();
            invoiceNumberField.clear();
            customerAddressField.clear();
            customerNameField.clear();
            totalAmountField.clear();
            paymentTermsField.clear();
        });

    }
}
