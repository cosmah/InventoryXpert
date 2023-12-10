package com.inventoryxpert.application.backend.repository;

import java.util.List;

import com.inventoryxpert.application.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE LOWER(e.employeeName) LIKE LOWER(CONCAT('%', :stringFilter, '%'))")
    List<Employee> search(@Param("stringFilter") String stringFilter);
}

