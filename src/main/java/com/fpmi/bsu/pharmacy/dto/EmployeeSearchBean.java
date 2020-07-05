package com.fpmi.bsu.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EmployeeSearchBean implements Serializable {

    private static final long serialVersionUID = -8654479741203298112L;

    private String firstName;
    private String lastName;
    private Integer minSalary;
    private Integer maxSalary;
}
