package com.inventoryxpert.application.backend.controller;

import java.util.List;

import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.service.CustomerService;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.findAll();
    }
}
