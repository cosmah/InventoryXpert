package com.inventoryxpert.application.backend.service;

import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.backend.repository.InvoiceLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineService {

    private final InvoiceLineRepository invoiceLineRepository;

    @Autowired
    public InvoiceLineService(InvoiceLineRepository invoiceLineRepository) {
        this.invoiceLineRepository = invoiceLineRepository;
    }

    public InvoiceLine saveInvoiceLine(InvoiceLine invoiceLine) {
        // Calculate total price before saving
        invoiceLine.setTotalPrice(invoiceLine.getQuantity() * invoiceLine.getUnitPrice());
        return invoiceLineRepository.save(invoiceLine);
    }

    public List<InvoiceLine> getAllInvoiceLines() {
        return invoiceLineRepository.findAll();
    }

    public InvoiceLine getInvoiceLineById(Long id) {
        return invoiceLineRepository.findById(id).orElse(null);
    }

    public void deleteInvoiceLine(Long id) {
        invoiceLineRepository.deleteById(id);
    }
}