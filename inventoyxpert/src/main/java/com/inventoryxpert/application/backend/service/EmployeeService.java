package com.inventoryxpert.application.backend.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.inventoryxpert.application.backend.entity.Employee;
import org.springframework.stereotype.Service;

import com.inventoryxpert.application.backend.repository.EmployeesRepository;

@Service
public class EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class
            .getName());

    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    public List<Employee> findAll(){
        return employeesRepository.findAll();
    }

    

    public List<Employee> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return employeesRepository.findAll();
        } else {
            return employeesRepository.search(stringFilter);
        }
    }

    public long count() {

        return employeesRepository.count();
    }

    public void delete(Employee employee) {
        if (employee == null) {
            LOGGER.log(java.util.logging.Level.SEVERE,
                    "Employee to delete is null.");
            return;
        }
        employeesRepository.delete(employee);
    }

    public Employee save(Employee employee) {
        if (employee == null) {
            LOGGER.log(java.util.logging.Level.SEVERE,
                   "Employee is null. Are you sure you have connected your form to the application?");
            return null;
        }
        employeesRepository.save(employee);
        return employee;
    }

    public Employee save(Long id, String employeeName, String employeeAddress, String employeePhone, String employeeEmail,
                         String employeeNextOfKin, String employeeNextOfKinPhone, String employeeNextOfKinAddress,
                         String employeeNextOfKinRelationship, String employeeNextOfKinOccupation, String employeeNextOfKinGender,
                         Date employeeDateOfBirth, String employeeGender, String employeeOccupation, String employeeMaritalStatus,
                         String employeeNationality, String employeeStateOfOrigin, int employeeTin) {

        
        Employee employee = new Employee();
        employee.setId(id);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeAddress(employeeAddress);
        employee.setEmployeePhone(employeePhone);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeeNextOfKin(employeeNextOfKin);
        employee.setEmployeeNextOfKinPhone(employeeNextOfKinPhone);
        employee.setEmployeeNextOfKinAddress(employeeNextOfKinAddress);
        employee.setEmployeeNextOfKinRelationship(employeeNextOfKinRelationship);
        employee.setEmployeeNextOfKinOccupation(employeeNextOfKinOccupation);
        employee.setEmployeeNextOfKinGender(employeeNextOfKinGender);
        employee.setEmployeeDateOfBirth(employeeDateOfBirth);
        employee.setEmployeeGender(employeeGender);
        employee.setEmployeeOccupation(employeeOccupation);
        employee.setEmployeeMaritalStatus(employeeMaritalStatus);
        employee.setEmployeeNationality(employeeNationality);
        employee.setEmployeeStateOfOrigin(employeeStateOfOrigin);
        employee.setEmployeeTin(employeeTin);



        
        return employeesRepository.save(employee);
    }

    
    
}
