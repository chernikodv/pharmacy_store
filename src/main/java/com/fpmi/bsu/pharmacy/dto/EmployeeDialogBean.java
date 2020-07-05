package com.fpmi.bsu.pharmacy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDialogBean implements Serializable {

    private static final long serialVersionUID = 100459135630842973L;

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Integer salary;
}
