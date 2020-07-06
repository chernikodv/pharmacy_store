package com.fpmi.bsu.pharmacy.controller;

import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
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

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(service.save(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<EmployeeDto> update(@RequestParam Integer id, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(service.update(id, employeeDto));
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Integer id) throws ResponseStatusException {
        EmployeeDto employee = service.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(path = "/remove/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<EmployeeDto>> findAll(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(service.findAll(params));
    }
}
