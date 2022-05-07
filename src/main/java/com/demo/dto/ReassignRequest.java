package com.demo.dto;

/**
 * class to represent the expected reimbursement reassign request
 */
public class ReassignRequest {
    private int managerId;
    private int reimbursementId;
    private int employeeId;
    public ReassignRequest(){}
    public ReassignRequest(int managerId, int reimbursementId, int employeeId) {
        this.managerId = managerId;
        this.reimbursementId = reimbursementId;
        this.employeeId = employeeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
