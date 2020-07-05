package com.fpmi.bsu.pharmacy.service;

import static com.fpmi.bsu.pharmacy.util.EmployeeMapper.*;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.dto.EmployeeSearchBean;
import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.repository.EmployeeRepository;
import com.fpmi.bsu.pharmacy.repository.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto save(EmployeeDialogBean dialogBean) {
        Employee toSave = mapDialogBean2Entity(dialogBean);
        Employee saved = employeeRepository.save(toSave);
        return mapEntity2Dto(saved);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<EmployeeDto> findById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDto employeeDto = mapEntity2Dto(employee.orElse(null));
        return Optional.ofNullable(employeeDto);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return mapEntityList2DtoList(employees);
    }

    @Override
    public List<EmployeeDto> findAll(EmployeeSearchBean searchBean) {
        EmployeeCriteria criteria = mapSearchBean2Criteria(searchBean);
        List<Employee> employees = employeeRepository.findAll(new EmployeeSpecification((criteria)));
        return mapEntityList2DtoList(employees);
    }
}
