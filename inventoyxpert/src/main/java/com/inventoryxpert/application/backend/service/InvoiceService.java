package com.inventoryxpert.application.backend.service;


import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> findAll() {
        return repository.findAll();
    }


    public Invoice save(Long id, String invoiceNumber, Date invoiceDate, String customerName, String customerAddress ,Double totalAmount, String paymentTerms) {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setInvoiceDate(invoiceDate);
        invoice.setCustomerName(customerName);
        invoice.setCustomerAddress(customerAddress);
        invoice.setTotalAmount(totalAmount);
        invoice.setPaymentTerms(paymentTerms);

        return repository.save(invoice);

    }

}
