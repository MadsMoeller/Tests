package com.example.tests.repositories;

import com.example.tests.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);
}
