package com.inventoryxpert.application.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventoryxpert.application.backend.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
 List<Employees> findByEmployeeName(String employeeName);
}

