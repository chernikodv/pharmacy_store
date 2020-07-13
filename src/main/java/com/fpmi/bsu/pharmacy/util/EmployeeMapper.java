package com.fpmi.bsu.pharmacy.util;

import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.model.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

    public static List<EmployeeDto> mapEntityList2DtoList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::mapEntity2Dto)
                .collect(Collectors.toList());
    }

    public static Employee mapDto2Entity(EmployeeDto employeeDto) {
        return new Employee()
                .setId(employeeDto.getId())
                .setFirstName(employeeDto.getFirstName())
                .setLastName(employeeDto.getLastName())
                .setSalary(employeeDto.getSalary());
    }

    public static EmployeeDto mapEntity2Dto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary());
    }
}
