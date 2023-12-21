package com.inventoryxpert.application.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.service.InvoiceLineService;

@RestController
public class InvoiceLineController {
    private final InvoiceLineService invoiceLineservice;

    public InvoiceLineController(InvoiceLineService invoiceLineservice) {
        this.invoiceLineservice = invoiceLineservice;
    }

    @GetMapping("/purchase")
    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLineservice.findAll();
    }
}
