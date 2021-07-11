package com.fpmi.bsu.pharmacy.repository;

import com.fpmi.bsu.pharmacy.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    // just a random comment
    // just a random comment 2
    // just a random comment 3
}