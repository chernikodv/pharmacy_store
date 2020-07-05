package com.fpmi.bsu.pharmacy.service;

import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
import com.fpmi.bsu.pharmacy.dto.EmployeeSearchBean;
import com.fpmi.bsu.pharmacy.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(EmployeeDialogBean dialogBean);
    void deleteById(Integer id);
    Optional<Employee> findById(Integer id);
    List<Employee> findAll();
    List<Employee> findAll(EmployeeSearchBean searchBean);
}
