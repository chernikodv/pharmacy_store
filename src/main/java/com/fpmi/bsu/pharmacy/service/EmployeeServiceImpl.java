package com.fpmi.bsu.pharmacy.service;

import static com.fpmi.bsu.pharmacy.util.EmployeeMapper.*;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.repository.EmployeeRepository;
import com.fpmi.bsu.pharmacy.repository.EmployeeSpecification;
import com.fpmi.bsu.pharmacy.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<EmployeeDto> findById(Integer id) {
        return repository.findById(id).map(EmployeeMapper::mapEntity2Dto);
    }

    @Override
    public List<EmployeeDto> findAll(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            List<Employee> employees = repository.findAll();
            return mapEntityList2DtoList(employees);
        }

        EmployeeCriteria criteria = new EmployeeCriteria(params);
        Specification<Employee> specification = new EmployeeSpecification(criteria);

        List<Employee> employees = null;
        if (criteria.isSortEnabled()) {
            Sort.Direction direction = Sort.Direction.fromString(criteria.getDirection());
            Sort sort = Sort.by(direction, criteria.getOrderBy());
            employees = repository.findAll(specification, sort);
        } else {
            employees = repository.findAll(specification);
        }

        return mapEntityList2DtoList(employees);
    }
}
