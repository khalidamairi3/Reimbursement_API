package com.demo.controllers;

import com.demo.entities.Employee;
import com.demo.entities.Reimbursement;
import com.demo.services.EmployeeService;
import com.demo.services.ReimbursementService;
import com.demo.utls.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Employee controller to receive and respond to all employee related requests
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ReimbursementService reimbursementService;

    private EmailClient emailClient = new EmailClient();
    final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    /**
     * method to allow employee to view all his reimbursements
     * @param employeeId
     * @return
     */
    @GetMapping("reimbursements/{employeeId}")
    public ResponseEntity getAllReimbursements(@PathVariable int employeeId){
        Optional<Employee> employeeOptional = employeeService.getByEmployeeId(employeeId);
        logger.debug("get reimbursement by employee id");
        if(employeeOptional.isPresent()){
            return ResponseEntity.ok(reimbursementService.getAllByEmployeeId(employeeId));
        }
        logger.error("failed");
        return ResponseEntity.notFound().build();

    }

    /**
     * Method to allow employee to upload a new reimbursement
     * @param employeeId
     * @param reimbursementRequest
     * @return
     */
    @PostMapping("{employeeId}/reimbursement")
    public ResponseEntity requestReimbursement(@PathVariable int employeeId,@RequestBody Reimbursement reimbursementRequest){
        try{
            Optional <Employee> optionalEmployee = employeeService.getByEmployeeId(employeeId);
            optionalEmployee.ifPresent(employee->{
                reimbursementRequest.setEmployee(employee);
                reimbursementRequest.setStatus("Pending");
                reimbursementService.addReimbursement(reimbursementRequest);
                emailClient.callPostEmail(employee.getEmail(),"Reimbursement created","you have created the following reimbursement" +reimbursementRequest.toString());
            });
            logger.debug("success post");
            return ResponseEntity.created(new URI("http://localhost/reimbursement/employee/" + reimbursementRequest.getId())).build();

        }catch(Exception e){
            e.printStackTrace();
            logger.error("failed post");
            return ResponseEntity.internalServerError().body("Error saving new reimbursement");
        }
    }

}
