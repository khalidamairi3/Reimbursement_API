package com.demo.repositories;

import com.demo.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepository extends JpaRepository <Reimbursement,Integer> {
    List <Reimbursement> findAllByManagerId(int id);
    List <Reimbursement> findAllByEmployeeId(int id);
    @Query(nativeQuery = true,value = "UPDATE reimbursement  SET employee_id= :employeeId where id= :reimbursementId")
    Reimbursement reAssignReimbursemnt(@Param("employeeId") int employeeId , @Param("reimbursementId") int reimbursementId);
    @Query(nativeQuery = true,value = "UPDATE reimbursement  SET status= :type where id= :reimbursementId")
    Reimbursement approveReimbursement(@Param("type") String type , @Param("reimbursementId") int reimbursementId);
}
