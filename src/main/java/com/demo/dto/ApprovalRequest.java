package com.demo.dto;

/**
 * class tp represent the expected reimbursement (approval/denial) request
 */
public class ApprovalRequest {
    private int reimbursementId;
    private int managerId;
    private String type;
    public ApprovalRequest(){}
    public ApprovalRequest(int reimbursementId, int managerId, String type) {
        this.reimbursementId = reimbursementId;
        this.managerId = managerId;
        this.type = type;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
