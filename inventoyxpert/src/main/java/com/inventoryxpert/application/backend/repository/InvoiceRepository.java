package com.inventoryxpert.application.backend.repository;

import com.inventoryxpert.application.backend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // List<Invoice> findByCustomerId(Long customerId);
    // List<Invoice> findByCustomerIdAndStatus(Long customerId, String status);
    // List<Invoice> findByStatus(String status);
    // List<Invoice> findByStatusAndCustomerId(String status, Long customerId);
    // List<Invoice> findByStatusAndCustomerIdAndDate(String status, Long customerId, String date);
    // List<Invoice> findByStatusAndDate(String status, String date);
    // List<Invoice> findByDate(String date);
    // List<Invoice> findByCustomerIdAndDate(Long customerId, String date);
    // List<Invoice> findByCustomerIdAndDateBetween(Long customerId, String startDate, String endDate);
    // List<Invoice> findByDateBetween(String startDate, String endDate);
    // List<Invoice> findByDateBetweenAndStatus(String startDate, String endDate, String status);
    // List<Invoice> findByDateBetweenAndCustomerId(String startDate, String endDate, Long customerId);
    // List<Invoice> findByDateBetweenAndCustomerIdAndStatus(String startDate, String endDate, Long customerId, String status);
    // List<Invoice> findByDateBetweenAndStatusAndCustomerId(String startDate, String endDate, String status, Long customerId);
}