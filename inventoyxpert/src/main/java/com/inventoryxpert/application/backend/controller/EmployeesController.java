package com.inventoryxpert.application.backend.controller;

import java.util.List;

import org.atmosphere.config.service.Get;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryxpert.application.backend.entity.Employees;
import com.inventoryxpert.application.backend.service.EmployeeService;

@RestController
public class EmployeesController {
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employees> getEmployees() {
        return employeeService.findAll();
    }
    
}
