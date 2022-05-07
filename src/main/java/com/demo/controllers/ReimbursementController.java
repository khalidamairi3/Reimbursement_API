package com.demo.controllers;


import com.demo.entities.Reimbursement;
import com.demo.services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * reimbursement controller to perform reimbursements related request
 */
@RestController
@RequestMapping("reimbursement")
public class ReimbursementController {

    @Autowired
    ReimbursementService reimbursementService;

    /**
     * method to get all reimbursement by manager id
     * @param managerId
     * @return
     */
    @GetMapping("/manager/{managerId}")
    public ResponseEntity getReimbursementByManagerId(@PathVariable int managerId){
        return ResponseEntity.ok(reimbursementService.getAllByManagerId(managerId));

    }

    /**
     * method to get all reimbursements by employee id
     * @param employeeId
     * @return
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity getReimbursementByEmployeeId(@PathVariable int employeeId){
        return ResponseEntity.ok(reimbursementService.getAllByEmployeeId(employeeId));

    }
}
