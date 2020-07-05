package com.fpmi.bsu.pharmacy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeSearchBean implements Serializable {

    private static final long serialVersionUID = -8654479741203298112L;

    private final String firstName;
    private final String lastName;
    private final Integer minSalary;
    private final Integer maxSalary;
}
