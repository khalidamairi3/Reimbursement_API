package com.demo.services;

import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getByEmployeeId(int employeeID){
        return employeeRepository.findById(employeeID);
    }
}
