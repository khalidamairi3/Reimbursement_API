package com.demo.services;

import com.demo.entities.Employee;
import com.demo.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTests {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    public void initBeforeTest() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService();
        employeeService.setEmployeeRepository(employeeRepository);
    }

    @Test
    public void shouldReturnEmployeebyId() {
        when(employeeRepository.findById(1)).thenReturn(Optional.empty());
        Optional <Employee> employee =employeeService.getByEmployeeId(1);
        assertTrue(!employee.isPresent());
    }
}
