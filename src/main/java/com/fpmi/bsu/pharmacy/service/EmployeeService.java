package com.fpmi.bsu.pharmacy.service;

import com.fpmi.bsu.pharmacy.dto.EmployeeDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto update(Integer id, EmployeeDto employeeDto);
    void deleteById(Integer id);
    Optional<EmployeeDto> findById(Integer id);
    List<EmployeeDto> findAll(Map<String, String> params);
}
