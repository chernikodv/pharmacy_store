package com.fpmi.bsu.pharmacy.controller;

import com.fpmi.bsu.pharmacy.dto.EmployeeDialogBean;
import com.fpmi.bsu.pharmacy.dto.EmployeeSearchBean;
import com.fpmi.bsu.pharmacy.model.Employee;
import com.fpmi.bsu.pharmacy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Employee> save(@RequestBody EmployeeDialogBean dialogBean) {
        return ResponseEntity.ok(employeeService.save(dialogBean));
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<Employee> update(@RequestBody EmployeeDialogBean dialogBean) {
        return ResponseEntity.ok(employeeService.save(dialogBean));
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) throws ResponseStatusException {
        Employee employee = employeeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Employee>> findAll(@RequestParam Map<String, String> params) {
        if (params.isEmpty()) {
            return ResponseEntity.ok(employeeService.findAll());
        }

        String firstName = params.get("firstName");
        String lastName = params.get("lastName");
        Integer minSalary = null;
        if (params.get("minSalary") != null) {
            minSalary = Integer.parseInt(params.get("minSalary"));
        }

        Integer maxSalary = null;
        if (params.get("maxSalary") != null) {
            maxSalary = Integer.parseInt(params.get("maxSalary"));
        }

        return ResponseEntity.ok(employeeService.findAll(new EmployeeSearchBean(firstName, lastName, minSalary, maxSalary)));
    }
}
