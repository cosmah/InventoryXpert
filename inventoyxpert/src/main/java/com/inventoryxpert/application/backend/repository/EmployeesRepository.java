package com.inventoryxpert.application.backend.repository;

import java.util.List;

import com.inventoryxpert.application.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
 List<Employee> findByEmployeeName(String employeeName);
}

