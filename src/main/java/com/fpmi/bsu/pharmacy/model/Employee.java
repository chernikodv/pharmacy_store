package com.fpmi.bsu.pharmacy.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "employee")
@EqualsAndHashCode(of = "id")
public class Employee implements Serializable {

    private static final long serialVersionUID = 3938771259447303100L;

    @Id
    @Column
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Integer salary;
}
