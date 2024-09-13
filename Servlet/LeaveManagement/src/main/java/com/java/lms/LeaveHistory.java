package com.java.lms;

import java.sql.Date;

public class LeaveHistory {

	private int leaveId;
	private int noOfDays;
	private String commentOfMan;
	private int empid;
	private Date sdate;
	private Date edate;
	private LeaveType leaveType;
	private LeaveStatus leaveStatus;
	private String leaveReason;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getCommentOfMan() {
		return commentOfMan;
	}

	public void setCommentOfMan(String commentOfMan) {
		this.commentOfMan = commentOfMan;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public LeaveHistory(int leaveId, int noOfDays, String commentOfMan, int empid, Date sdate, Date edate,
			LeaveType leaveType, LeaveStatus leaveStatus, String leaveReason) {

		this.leaveId = leaveId;
		this.noOfDays = noOfDays;
		this.commentOfMan = commentOfMan;
		this.empid = empid;
		this.sdate = sdate;
		this.edate = edate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.leaveReason = leaveReason;
	}

	public LeaveHistory() {

	}

	@Override
	public String toString() {
		return "LeaveHistory [leaveId=" + leaveId + ", noOfDays=" + noOfDays + ", commentOfMan=" + commentOfMan
				+ ", empid=" + empid + ", sdate=" + sdate + ", edate=" + edate + ", leaveType=" + leaveType
				+ ", leaveStatus=" + leaveStatus + ", leaveReason=" + leaveReason + "]";
	}

}
