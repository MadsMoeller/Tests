package com.example.tests.services;

import com.example.tests.models.Employee;
import com.example.tests.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
}
