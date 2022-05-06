package com.demo.controllers;

import com.demo.dto.ReimbursementRequest;
import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.entities.Reimbursement;
import com.demo.services.EmployeeService;
import com.demo.services.ManagerService;
import com.demo.services.ReimbursementService;
import com.demo.utls.EmailClient;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    ReimbursementService reimbursementService;

    private EmailClient emailClient = new EmailClient();
    @GetMapping("reimbursements/{employeeId}")
    public ResponseEntity getAllReimbursements(@PathVariable int employeeId){
        Optional<Employee> employeeOptional = employeeService.getByEmployeeId(employeeId);
        if(employeeOptional.isPresent()){
            return ResponseEntity.ok(reimbursementService.getAllByEmployeeId(employeeId));
        }
        return ResponseEntity.notFound().build();

    }
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

            return ResponseEntity.created(new URI("http://localhost/reimbursement/employee/" + reimbursementRequest.getId())).build();

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new reimbursement");
        }
    }

}
