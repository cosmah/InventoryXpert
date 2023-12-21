package com.inventoryxpert.application.backend.service;

import com.github.javaparser.utils.Log;
import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.repository.InvoiceRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private static final Logger LOGGER = Logger.getLogger(InvoiceService.class.getName());

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getInvoice(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice findInvoice(Long id) {
        return invoiceRepository.findById(id).get();
    }

    

    public long countInvoices() {
        return invoiceRepository.count();
    }

    public void deleteInvoice(Invoice invoice) {
        if (invoice == null) {
            LOGGER.log(Level.SEVERE,
                    "Invoice is null. Are you sure you have connected your form to the application?");

            return;
        }
        invoiceRepository.delete(invoice);
    }

    public void save(Invoice invoice) {
        if (invoice == null) {
            LOGGER.log(Level.SEVERE,
                    "Invoice is null. Are you sure you have connected your form to the application?");
            return;
        }
        invoiceRepository.save(invoice);
    }

    public Invoice save(Long id, String customerName, String customerAddress, String paymentTerms, String invoiceNumber,
            LocalDate invoiceDate, LocalDate expiryDate, String contactPerson, List<InvoiceLine> invoiceLines,
            Double totalSales) {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setCustomerName(customerName);
        invoice.setCustomerAddress(customerAddress);
        invoice.setPaymentTerms(paymentTerms);
        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setInvoiceDate(invoiceDate);
        invoice.setExpiryDate(expiryDate);
        invoice.setContactPerson(contactPerson);
        invoice.setInvoiceLines(invoiceLines);
        invoice.setTotalSales(totalSales);
        return invoiceRepository.save(invoice);
    }

}