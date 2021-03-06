package com.demo.repositories;

import com.demo.entities.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * the manager repository to perform database operations
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    Optional <Manager> findById(int id);
}
