package com.inventoryxpert.application.backend.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.repository.CustomerRepository;


@Service
public class CustomerService implements Serializable{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
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
            throw new IllegalArgumentException("Customer to delete is null.");
        }
        customerRepository.delete(customer);
    }

    public void save(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer is null. Are you sure you have connected your form to the application?");
        }
        customerRepository.save(customer);
    }

    public Customer save(Long id, String customerName, String customerAddress, String customerPhone, String customerEmail, String customerContactPerson, int customerTin) {
        Customer customer = new Customer(id, customerName, customerAddress, customerPhone, customerEmail, customerContactPerson, customerTin);
        return customerRepository.save(customer);
    }
    
}
