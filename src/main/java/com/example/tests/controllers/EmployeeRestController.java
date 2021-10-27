package com.example.tests.controllers;

import com.example.tests.models.Employee;
import com.example.tests.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
}
