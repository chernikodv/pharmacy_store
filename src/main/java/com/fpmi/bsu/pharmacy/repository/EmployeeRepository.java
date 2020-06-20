package com.fpmi.bsu.pharmacy.repository;

import com.fpmi.bsu.pharmacy.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
}