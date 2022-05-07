package com.demo.services;

import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * employee service to provide all needed services to the controllers
 */
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getByEmployeeId(int employeeID){
        return employeeRepository.findById(employeeID);
    }
}
