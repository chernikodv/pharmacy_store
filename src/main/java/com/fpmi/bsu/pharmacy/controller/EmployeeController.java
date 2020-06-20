package com.fpmi.bsu.pharmacy.controller;

import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping(path = "/employee")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) throws ResponseStatusException {
        Employee employee = employeeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(path = "/employee/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/employees", params = {"orderBy", "direction"})//, "page", "size"})
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "id", required = false) String orderBy,
                                     @RequestParam(defaultValue = "asc", required = false) String direction) {
//                                     @RequestParam(defaultValue = "1", required = false) Integer page,
//                                     @RequestParam(defaultValue = "10", required = false) Integer size) {
        Sort sort = null;
        if (direction.equals("asc")) {
            sort = Sort.by(Sort.Direction.ASC, orderBy);
        } else {
            sort = Sort.by(Sort.Direction.DESC, orderBy);
        }

        return ResponseEntity.ok(employeeService.findAll(sort));
    }

    @GetMapping(path = "/employees")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }
}
