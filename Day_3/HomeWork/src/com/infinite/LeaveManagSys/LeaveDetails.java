package com.infinite.LeaveManagSys;

import java.util.Date;

public class LeaveDetails {
	
	private int empId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String leaveReason;
	private int noOfDays;
	private Date leaveAppliedOn;
	private LeaveType leaveType;
	
	public LeaveDetails() {
	}

	public LeaveDetails(int empId, Date leaveStartDate, Date leaveEndDate, String leaveReason, int noOfDays,
			Date leaveAppliedOn, LeaveType leaveType) {
		
		this.empId = empId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveReason = leaveReason;
		this.noOfDays = noOfDays;
		this.leaveAppliedOn = leaveAppliedOn;
		this.leaveType = leaveType;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Date getLeaveAppliedOn() {
		return leaveAppliedOn;
	}

	public void setLeaveAppliedOn(Date leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	

	@Override
	public String toString() {
		return "\nLeave Management System\n" +"--------------------------------"+
                "Employee No=" + empId +"--------------------------------"+ "\n\t\t Leave Start Date\t=\t" 
				+ leaveStartDate + "\n\t\t Leave End Date\t\t=\t" + leaveEndDate
				+ "\n\t\t Leave Reason\t\t=\t" + leaveReason + "\n\t\t Numbers of Days\t=\t" + noOfDays 
				+ "\n\t\t Leave Applied On\t=\t" + leaveAppliedOn + "\n\t\t LeaveType\t\t=\t" 
				+ leaveType + "\n------------------------------------------------------------------------------";
	}
	
	
	
	
	

}
