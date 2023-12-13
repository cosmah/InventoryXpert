package com.inventoryxpert.application.backend.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.entity.Employee;
import com.inventoryxpert.application.backend.repository.CustomerRepository;

import java.util.Date;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerService.class
            .getName());

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<String> getAllCustomerNames() {
        return customerRepository.findAll().stream()
                .map(Customer::getCustomerName)
                .collect(Collectors.toList());
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return customerRepository.findAll();
        } else {
            return customerRepository.search(stringFilter);
        }

    }

    public long count() {

        return customerRepository.count();
    }

    public void delete(Customer customer) {
        if (customer == null) {
            LOGGER.log(Level.SEVERE, "Customer to delete is null.");
        }
        customerRepository.delete(customer);
    }

    public void save(Customer customer) {
        if (customer == null) {
            LOGGER.log(Level.SEVERE, "Customer is null. Are you sure you have connected your form to the application?");
            return;
        }
        customerRepository.save(customer);
    }

    public Customer save(Long id, String customerName, String customerAddress, String customerPhone,
            String customerEmail, Employee customerContactPerson, int customerTin) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCustomerName(customerName);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerPhone(customerPhone);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerContactPerson(customerContactPerson);
        customer.setCustomerTin(customerTin);

        return customerRepository.save(customer);
    }

}
