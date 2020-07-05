package com.fpmi.bsu.pharmacy.service;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
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
    public Employee save(EmployeeDialogBean dialogBean) {
        Employee employee = new Employee();
        employee.setId(dialogBean.getId());
        employee.setFirstName(dialogBean.getFirstName());
        employee.setLastName(dialogBean.getLastName());
        employee.setSalary(dialogBean.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAll(EmployeeSearchBean searchBean) {
        String firstName = searchBean.getFirstName();
        String lastName = searchBean.getLastName();
        Integer minSalary = searchBean.getMinSalary();
        Integer maxSalary = searchBean.getMaxSalary();
        EmployeeCriteria criteria = new EmployeeCriteria(firstName, lastName, minSalary, maxSalary);
        return employeeRepository.findAll(new EmployeeSpecification((criteria)));
    }
}
