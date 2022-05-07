package com.demo.services;

import com.demo.entities.Reimbursement;
import com.demo.repositories.ReimbursementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;

public class ReimbursementServiceTest {
    private ReimbursementRepository reimbursementRepository;
    private ReimbursementService reimbursementService;

    @BeforeEach
    public void initBeforeTest() {
        reimbursementRepository = mock(ReimbursementRepository.class);
        reimbursementService = new ReimbursementService();
        reimbursementService.setReimbursementRepository(reimbursementRepository );
    }

    @Test
    public void shouldReturnAllReimbursemnets() {
        when(reimbursementRepository.findAll()).thenReturn(Collections.emptyList());
        List<Reimbursement>  reimbursements = reimbursementService.getAll();
        assertTrue(reimbursements.isEmpty());
    }

    @Test
    public void shouldReturnReimbursemnets() {
        when(reimbursementRepository.findAllByManagerId(1)).thenReturn(Collections.emptyList());
        List<Reimbursement>  reimbursements = reimbursementService.getAllByManagerId(1);
        assertTrue(reimbursements.isEmpty());
    }
    @Test
    public void shouldReturnReimbursemnetsbyEmployee() {
        when(reimbursementRepository.findAllByEmployeeId(1)).thenReturn(Collections.emptyList());
        List<Reimbursement>  reimbursements = reimbursementService.getAllByEmployeeId(1);
        assertTrue(reimbursements.isEmpty());
    }

    @Test
    public void shouldReturnReimbursemnetbyId() {
        when(reimbursementRepository.findById(1)).thenReturn(Optional.empty());
        Optional <Reimbursement> reimbursement = reimbursementService.getReimbursementById(1);
        assertTrue(!reimbursement.isPresent());
    }

}
