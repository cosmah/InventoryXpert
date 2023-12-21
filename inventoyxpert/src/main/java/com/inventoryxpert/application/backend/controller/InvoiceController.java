package com.inventoryxpert.application.backend.controller;

import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService service) {
        this.invoiceService = service;
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceService.getAllInvoices();
    }

    // @PostMapping("/invoices")
    // public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
    //     Invoice createdInvoice = invoiceService.createInvoice(invoice);
    //     return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    // }
}