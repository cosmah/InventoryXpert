package com.inventoryxpert.application.backend.repository;

import com.inventoryxpert.application.backend.entity.InvoiceLine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long> {

    // List<InvoiceLine> search(String stringFilter);
}