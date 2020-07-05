package com.fpmi.bsu.pharmacy.criteria;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeCriteria implements Serializable {

    private static final long serialVersionUID = -4727717479756006862L;

    private final String firstName;
    private final String lastName;
    private final Integer minSalary;
    private final Integer maxSalary;
}
