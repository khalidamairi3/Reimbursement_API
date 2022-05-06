package com.demo.services;

import com.demo.entities.Manager;
import com.demo.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    public Optional <Manager> getManegerById(int managerId){
        return managerRepository.findById(managerId);
    }
}
