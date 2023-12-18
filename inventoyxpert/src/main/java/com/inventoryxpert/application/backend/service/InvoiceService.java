package com.inventoryxpert.application.backend.service;

import com.inventoryxpert.application.backend.entity.Invoice;
import com.inventoryxpert.application.backend.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

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

    // public List<Invoice> findByCustomerId(Long customerId) {
    //     return invoiceRepository.findByCustomerId(customerId);
    // }

    // public List<Invoice> findByCustomerIdAndStatus(Long customerId, String status) {
    //     return invoiceRepository.findByCustomerIdAndStatus(customerId, status);
    // }   
    
    // public List<Invoice> findByStatus(String status) {
    //     return invoiceRepository.findByStatus(status);
    // }   

    // public List<Invoice> findByStatusAndCustomerId(String status, Long customerId) {
    //     return invoiceRepository.findByStatusAndCustomerId(status, customerId);
    // }

    // public List<Invoice> findByStatusAndCustomerIdAndDate(String status, Long customerId, String date) {
    //     return invoiceRepository.findByStatusAndCustomerIdAndDate(status, customerId, date);
    // }

    // public List<Invoice> findByStatusAndDate(String status, String date) {
    //     return invoiceRepository.findByStatusAndDate(status, date);
    // }

    // public List<Invoice> findByDate(String date) {
    //     return invoiceRepository.findByDate(date);
    // }

    // public List<Invoice> findByCustomerIdAndDate(Long customerId, String date) {
    //     return invoiceRepository.findByCustomerIdAndDate(customerId, date);
    // }

    // public List<Invoice> findByCustomerIdAndDateBetween(Long customerId, String startDate, String endDate) {
    //     return invoiceRepository.findByCustomerIdAndDateBetween(customerId, startDate, endDate);
    // }

    // public List<Invoice> findByDateBetween(String startDate, String endDate) {
    //     return invoiceRepository.findByDateBetween(startDate, endDate);
    // }

    // public List<Invoice> findByDateBetweenAndStatus(String startDate, String endDate, String status) {
    //     return invoiceRepository.findByDateBetweenAndStatus(startDate, endDate, status);
    // }

    // public List<Invoice> findByDateBetweenAndCustomerId(String startDate, String endDate, Long customerId) {
    //     return invoiceRepository.findByDateBetweenAndCustomerId(startDate, endDate, customerId);
    // }

    // public List<Invoice> findByDateBetweenAndCustomerIdAndStatus(String startDate, String endDate, Long customerId, String status) {
    //     return invoiceRepository.findByDateBetweenAndCustomerIdAndStatus(startDate, endDate, customerId, status);
    // }

    // public List<Invoice> findByDateBetweenAndStatusAndCustomerId(String startDate, String endDate, String status, Long customerId) {
    //     return invoiceRepository.findByDateBetweenAndStatusAndCustomerId(startDate, endDate, status, customerId);
    // }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    
}