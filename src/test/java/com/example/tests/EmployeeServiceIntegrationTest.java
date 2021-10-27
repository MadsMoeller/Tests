package com.example.tests;

import com.example.tests.models.Employee;
import com.example.tests.repositories.EmployeeRepository;
import com.example.tests.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class EmployeeServiceIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceTestContextConfiguration{

        @Bean
        public EmployeeService employeeService(){
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        Employee employee = new Employee("alex");

        Mockito.when(employeeRepository.findByName(employee.getName())).thenReturn(employee);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound(){
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);

        assertEquals(found.getName(), name);
    }
}
