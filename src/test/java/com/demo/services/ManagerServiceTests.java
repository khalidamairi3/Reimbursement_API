package com.demo.services;

import com.demo.entities.Manager;
import com.demo.repositories.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerServiceTests {

    private ManagerRepository managerRepository;
    private ManagerService managerService;

    @BeforeEach
    public void initBeforeTest() {
        managerRepository = mock(ManagerRepository.class);
        managerService = new ManagerService();
        managerService.setManagerRepository(managerRepository );
    }

    @Test
    public void shouldReturnManagerbyId() {
        when(managerRepository.findById(1)).thenReturn(Optional.empty());
        Optional <Manager> manager = managerService.getManegerById(1);
        assertTrue(!manager.isPresent());
    }

}
