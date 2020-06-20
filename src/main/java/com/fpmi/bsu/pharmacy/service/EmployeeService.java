package com.fpmi.bsu.pharmacy.service;

import com.fpmi.bsu.pharmacy.model.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    void deleteById(Integer id);
    Optional<Employee> findById(Integer id);
    List<Employee> findAll(Sort sort);
    List<Employee> findAll();
    List<Employee> findByFirstName(String firstName);
}
