package com.demo.services;

import com.demo.entities.Manager;
import com.demo.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * manager service to provide all needed services to the controllers
 */
@Service
public class ManagerService {
    private ManagerRepository managerRepository;
    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    public Optional <Manager> getManegerById(int managerId){
        return managerRepository.findById(managerId);
    }
}
