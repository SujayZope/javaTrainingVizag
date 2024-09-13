package com.java.payroll;

public class LeaveDetails {

    private int leaveId;
    private int empId;
    private int leaveTaken;
    private double lossOfPay;


    public LeaveDetails(int leaveId, int empId, int leaveTaken, double lossOfPay) {
        this.leaveId = leaveId;
        this.empId = empId;
        this.leaveTaken = leaveTaken;
        this.lossOfPay = lossOfPay;
    }

    public LeaveDetails() {
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(int leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    public double getLossOfPay() {
        return lossOfPay;
    }

    public void setLossOfPay(double lossOfPay) {
        this.lossOfPay = lossOfPay;
    }


    @Override
    public String toString() {
        return "LeaveDetails{" +
                "leaveId=" + leaveId +
                ", empId=" + empId +
                ", leaveTaken=" + leaveTaken +
                ", lossOfPay=" + lossOfPay +
                '}';
    }
}

