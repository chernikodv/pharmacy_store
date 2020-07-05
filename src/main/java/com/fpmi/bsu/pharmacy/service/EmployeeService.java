package com.fpmi.bsu.pharmacy.service;

import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.dto.EmployeeSearchBean;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto save(EmployeeDialogBean dialogBean);
    void deleteById(Integer id);
    Optional<EmployeeDto> findById(Integer id);
    List<EmployeeDto> findAll();
    List<EmployeeDto> findAll(EmployeeSearchBean searchBean);
}
