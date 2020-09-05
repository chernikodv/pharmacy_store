package com.fpmi.bsu.pharmacy.criteria;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.FIRST_NAME;
import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.LAST_NAME;
import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.MIN_SALARY;
import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.MAX_SALARY;
import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.ORDER_BY;
import static com.fpmi.bsu.pharmacy.criteria.EmployeeCriteriaParam.DIRECTION;

@Data
public class EmployeeCriteria implements Serializable {

    private static final long serialVersionUID = 7560826483678386560L;

    private final String firstName;
    private final String lastName;
    private final Integer minSalary;
    private final Integer maxSalary;
    private final String orderBy;
    private final String direction;

    public EmployeeCriteria(Map<String, String> params) {
        this.firstName = params.get(FIRST_NAME.getParam());
        this.lastName = params.get(LAST_NAME.getParam());
        this.orderBy = params.get(ORDER_BY.getParam());
        this.direction = params.get(DIRECTION.getParam());

        String minSalaryParam = params.get(MIN_SALARY.getParam());
        if (minSalaryParam != null) {
            this.minSalary = Integer.parseInt(minSalaryParam);
        } else {
            this.minSalary = null;
        }

        String maxSalaryParam = params.get(MAX_SALARY.getParam());
        if (maxSalaryParam != null) {
            this.maxSalary = Integer.parseInt(maxSalaryParam);
        } else {
            this.maxSalary = null;
        }
    }

    public boolean isSortEnabled() {
        return orderBy != null && direction != null;
    }
}
