package com.fpmi.bsu.pharmacy.controller;

import com.fpmi.bsu.pharmacy.dto.EmployeeDto;
import com.fpmi.bsu.pharmacy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
