package com.demo.dto;

public class ReimbursementRequest {
    private int id;
    private String date;
    private double amount;
    private String status;
    private int managerId;
    private int empolyeeId;
    public ReimbursementRequest(){};
    public ReimbursementRequest(int id, String date, double amount, String status, int managerId, int empolyeeId) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.managerId = managerId;
        this.empolyeeId = empolyeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(int empolyeeId) {
        this.empolyeeId = empolyeeId;
    }
}
