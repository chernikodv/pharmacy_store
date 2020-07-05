package com.fpmi.bsu.pharmacy.util;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.dto.EmployeeSearchBean;
import com.fpmi.bsu.pharmacy.model.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

    public static Employee mapDialogBean2Entity(EmployeeDialogBean dialogBean) {
        return new Employee()
                .setId(dialogBean.getId())
                .setFirstName(dialogBean.getFirstName())
                .setLastName(dialogBean.getLastName())
                .setSalary(dialogBean.getSalary());
    }

    public static EmployeeDto mapEntity2Dto(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeDto()
                .setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setSalary(employee.getSalary());
    }

    public static List<EmployeeDto> mapEntityList2DtoList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::mapEntity2Dto)
                .collect(Collectors.toList());
    }

    public static EmployeeCriteria mapSearchBean2Criteria(EmployeeSearchBean searchBean) {
        return new EmployeeCriteria()
                .setFirstName(searchBean.getFirstName())
                .setLastName(searchBean.getLastName())
                .setMinSalary(searchBean.getMinSalary())
                .setMaxSalary(searchBean.getMaxSalary());
    }
}
