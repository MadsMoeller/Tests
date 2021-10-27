package com.example.tests;

import com.example.tests.models.Employee;
import com.example.tests.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee(){
        //given
        Employee employee = new Employee("alex");
        entityManager.persist(employee);
        entityManager.flush();

        //when
        Employee found = employeeRepository.findByName(employee.getName());

        //then
        assertEquals(found.getName(), employee.getName());
    }
}
