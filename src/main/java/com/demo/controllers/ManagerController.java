package com.demo.controllers;

import com.demo.dto.ApprovalRequest;
import com.demo.dto.ReassignRequest;
import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.entities.Reimbursement;
import com.demo.services.EmployeeService;
import com.demo.services.ManagerService;
import com.demo.services.ReimbursementService;
import com.demo.utls.EmailClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("manager")
/**
 * Manager controller to receive and perform all manager duties requests
 */
public class ManagerController {

    @Autowired
    ManagerService managerService;
    @Autowired
    ReimbursementService reimbursementService;

    @Autowired
    EmployeeService employeeService;
    final Logger logger = LoggerFactory.getLogger(ManagerController.class);
    private EmailClient emailClient = new EmailClient();

    /**
     * method to all a manager to get and view all reimbursements
     * @param managerId the manager id
     * @return
     */
    @GetMapping("reimbursements/{managerId}")
    public ResponseEntity getAllReimbursements(@PathVariable int managerId){
        Optional <Manager> managerOptional = managerService.getManegerById(managerId);
        if(managerOptional.isPresent()){
            logger.debug("success manager get");
            return ResponseEntity.ok(reimbursementService.getAll());
        }
        logger.error("not found manager");
        return ResponseEntity.notFound().build();

    }

    /**
     * method to allow manager to reassign reimbursements to different employee
     * @param reassignRequest object that contains managerid reimbursementid and employeeId
     * @return
     */
    @PutMapping("reassign")
    public ResponseEntity reAssignReumbursement(@RequestBody ReassignRequest reassignRequest){
        Optional <Manager> managerOptional = managerService.getManegerById(reassignRequest.getManagerId());
        if(managerOptional.isPresent()){
            Optional <Employee> optionalEmployee = employeeService.getByEmployeeId(reassignRequest.getEmployeeId());
            Optional <Reimbursement> optionalReimbursement = reimbursementService.getReimbursementById(reassignRequest.getReimbursementId());
            if(optionalEmployee.isPresent() && optionalReimbursement.isPresent()){
                optionalReimbursement.ifPresent(reimbursement -> optionalEmployee.ifPresent(employee -> {
                    reimbursement.setEmployee(employee);
                    reimbursementService.reAssignReimburesement(reimbursement);
                    emailClient.callPostEmail(employee.getEmail(),"Reimbursement reassigned"," the following reimbursement is now assigned to you " +reimbursement.toString());
                }));
                logger.debug("reassigned successfully");
                return ResponseEntity.accepted().build();
            }
            logger.error("reassign error");
            return ResponseEntity.notFound().build();
        }
        logger.error("reassign error");
        return ResponseEntity.notFound().build();
    }

    /**
     * Method to allow manager to approve or deny a specific reimbursement
     * @param approvalRequest object contains manager id , reimbursementId and approval type(approve/denied)
     * @return
     */
    @PutMapping("approve")
    public ResponseEntity reimbursementApprove(@RequestBody ApprovalRequest approvalRequest){
        Optional <Manager> managerOptional = managerService.getManegerById(approvalRequest.getManagerId());
        Optional <Reimbursement> optionalReimbursement = reimbursementService.getReimbursementById(approvalRequest.getReimbursementId());
        if(managerOptional.isPresent() && optionalReimbursement.isPresent()){

            reimbursementService.approveReimbursement(approvalRequest.getReimbursementId(),approvalRequest.getType());
            emailClient.callPostEmail(optionalReimbursement.get().getEmployee().getEmail(),"Reimbursement status update "," the following reimbursement is now " + approvalRequest.getType() + " " +optionalReimbursement.get().toString());
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

}
