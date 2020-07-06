package com.fpmi.bsu.pharmacy.service;

import static com.fpmi.bsu.pharmacy.util.EmployeeMapper.*;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.repository.EmployeeRepository;
import com.fpmi.bsu.pharmacy.repository.EmployeeSpecification;
import com.fpmi.bsu.pharmacy.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = repository.save(mapDto2Entity(employeeDto));
        return mapEntity2Dto(employee);
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isEmpty()) {
            return save(employeeDto);
        }

        Employee employee = repository.save(mapDto2Entity(employeeDto, optionalEmployee.get()));
        return mapEntity2Dto(employee);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<EmployeeDto> findById(Integer id) {
        return repository.findById(id).map(EmployeeMapper::mapEntity2Dto);
    }

    @Override
    public List<EmployeeDto> findAll(Map<String, String> params) {
        if (params.isEmpty()) {
            mapEntityList2DtoList(repository.findAll());
        }

        String firstName = params.get("firstName");
        String lastName = params.get("lastName");
        Integer minSalary = null;
        if (params.get("minSalary") != null) {
            minSalary = Integer.parseInt(params.get("minSalary"));
        }

        Integer maxSalary = null;
        if (params.get("maxSalary") != null) {
            maxSalary = Integer.parseInt(params.get("maxSalary"));
        }

        EmployeeCriteria criteria = new EmployeeCriteria(firstName, lastName, minSalary, maxSalary);
        return mapEntityList2DtoList(repository.findAll(new EmployeeSpecification(criteria)));
    }
}
