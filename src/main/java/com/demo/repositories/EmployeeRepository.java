package com.demo.repositories;

import com.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the employee repository to perform database operations
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
