package com.fpmi.bsu.pharmacy.criteria;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class EmployeeCriteria implements Serializable {

    private static final long serialVersionUID = -4727717479756006862L;

    private String firstName;
    private String lastName;
    private Integer minSalary;
    private Integer maxSalary;
}
