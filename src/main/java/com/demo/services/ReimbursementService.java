package com.demo.services;

import com.demo.entities.Reimbursement;
import com.demo.repositories.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * reimbursement service to provide all needed services to the controllers
 */
@Service
public class ReimbursementService {
    ReimbursementRepository reimbursementRepository;
    @Autowired
    public void setReimbursementRepository(ReimbursementRepository reimbursementRepository){
        this.reimbursementRepository = reimbursementRepository;
    }


    public List<Reimbursement> getAllByManagerId(int id){
        return reimbursementRepository.findAllByManagerId(id);
    }
    public List<Reimbursement> getAllByEmployeeId(int id){
        return reimbursementRepository.findAllByEmployeeId(id);
    }
    public List<Reimbursement> getAll(){
        return reimbursementRepository.findAll();
    }
    public Optional<Reimbursement> getReimbursementById(int reimbursementId){
        return reimbursementRepository.findById(reimbursementId);
    }
    public void addReimbursement(Reimbursement rq){
        reimbursementRepository.save(rq);
    }
    public Reimbursement reAssignReimburesement(Reimbursement reimbursement){
        return reimbursementRepository.reAssignReimbursemnt(reimbursement.getEmployee().getId(),reimbursement.getId());
    }
    public void approveReimbursement(int id,String type){
        if(type.equals("approved") || type.equals("denied"))
        reimbursementRepository.approveReimbursement(type,id);
    }
}
