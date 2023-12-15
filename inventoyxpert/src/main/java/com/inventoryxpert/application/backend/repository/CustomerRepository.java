package com.inventoryxpert.application.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventoryxpert.application.backend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE LOWER(c.customerName) LIKE LOWER(CONCAT('%', :stringFilter, '%'))")
    List<Customer> search(@Param("stringFilter") String stringFilter);

    Customer findByCustomerName(String customerName);

}