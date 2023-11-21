package com.inventoryxpert.application.backend.controller;

import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService service;

    @Autowired
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return service.findAll();
    }
}
