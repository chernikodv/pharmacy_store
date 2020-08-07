package com.fpmi.bsu.pharmacy.repository;

import com.fpmi.bsu.pharmacy.criteria.EmployeeCriteria;
import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.model.Employee_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {

    private final EmployeeCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        String firstName = criteria.getFirstName();
        if (firstName != null) {
            predicates.add(builder.like(root.get(Employee_.firstName), firstName + "%"));
        }

        String lastName = criteria.getLastName();
        if (lastName != null) {
            predicates.add(builder.like(root.get(Employee_.lastName), lastName + "%"));
        }

        Integer minSalary = criteria.getMinSalary();
        if (minSalary != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get(Employee_.salary), minSalary));
        }

        Integer maxSalary = criteria.getMaxSalary();
        if (maxSalary != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get(Employee_.salary), maxSalary));
        }

        return builder.and(predicates.toArray(Predicate[]::new));
    }
}
