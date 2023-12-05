package com.inventoryxpert.application.backend.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.inventoryxpert.application.backend.entity.Employees;
import com.inventoryxpert.application.backend.repository.EmployeesRepository;

@Service
public class EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class
            .getName());

    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> findAll(){
        return employeesRepository.findAll();
    }

    // public List<Employees> findAll(String stringFilter) {
    //     if (stringFilter == null || stringFilter.isEmpty()) {
    //         return employeesRepository.findAll();
    //     } else {
    //         return employeesRepository.search(stringFilter);
    //     }
    // }

    public long count() {

        return employeesRepository.count();
    }

    public void delete(Employees employees) {
        if (employees == null) {
            LOGGER.log(java.util.logging.Level.SEVERE,
                    "Employees to delete is null.");
            return;
        }
        employeesRepository.delete(employees);
    }

    public Employees save(Employees employees) {
        if (employees == null) {
            LOGGER.log(java.util.logging.Level.SEVERE,
                   "Employees is null. Are you sure you have connected your form to the application?");
            return null;
        }
        employeesRepository.save(employees);
        return employees;
    }

    public Employees save(Long id,String employeeName, String employeeAddress, String employeePhone, String employeeEmail,
                          String employeeNextOfKin, String employeeNextOfKinPhone, String employeeNextOfKinAddress,
                          String employeeNextOfKinRelationship, String employeeNextOfKinOccupation, String employeeNextOfKinGender,
                          Date employeeDateOfBirth, String employeeGender, String employeeOccupation, String employeeMaritalStatus,
                          String employeeNationality, String employeeStateOfOrigin, int employeeTin) {

        
        Employees employees = new Employees();
        employees.setId(id);
        employees.setEmployeeName(employeeName);
        employees.setEmployeeAddress(employeeAddress);
        employees.setEmployeePhone(employeePhone);
        employees.setEmployeeEmail(employeeEmail);
        employees.setEmployeeNextOfKin(employeeNextOfKin);
        employees.setEmployeeNextOfKinPhone(employeeNextOfKinPhone);
        employees.setEmployeeNextOfKinAddress(employeeNextOfKinAddress);
        employees.setEmployeeNextOfKinRelationship(employeeNextOfKinRelationship);
        employees.setEmployeeNextOfKinOccupation(employeeNextOfKinOccupation);
        employees.setEmployeeNextOfKinGender(employeeNextOfKinGender);
        employees.setEmployeeDateOfBirth(employeeDateOfBirth);
        employees.setEmployeeGender(employeeGender);
        employees.setEmployeeOccupation(employeeOccupation);
        employees.setEmployeeMaritalStatus(employeeMaritalStatus);
        employees.setEmployeeNationality(employeeNationality);
        employees.setEmployeeStateOfOrigin(employeeStateOfOrigin);
        employees.setEmployeeTin(employeeTin);



        
        return employeesRepository.save(employees);
    }

    
    
}
