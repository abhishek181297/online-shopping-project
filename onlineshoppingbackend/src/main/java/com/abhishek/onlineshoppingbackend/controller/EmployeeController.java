package com.abhishek.onlineshoppingbackend.controller;

import com.abhishek.onlineshoppingbackend.dao.EmployeeRepository;
import com.abhishek.onlineshoppingbackend.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employee = employeeRepository.save(employee);
        log.info("Employee saved successfully - {}", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
       Optional<Employee> employee =  employeeRepository.findById(id);
       return new ResponseEntity<>(employee.orElse(null), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{dept}")
    public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable(value = "dept") String dept) {
        List<Employee> employee = employeeRepository.findByDept(dept);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
