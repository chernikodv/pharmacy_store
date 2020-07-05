package com.fpmi.bsu.pharmacy.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = -1202342631303918097L;

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;
}
