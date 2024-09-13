package com.java.lms;

import java.sql.Date;

public class Employee {

	private int empid;
	private String ename;
	private String email;
	private String mobNo;
	private Date dateJoin;
	private String dept;
	private int managerId;
	private int leaveAvail;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLeaveAvail() {
		return leaveAvail;
	}

	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}

	public Employee(int empid, String ename, String email, String mobNo, Date dateJoin, String dept, int managerId,
			int leaveAvail) {

		this.empid = empid;
		this.ename = ename;
		this.email = email;
		this.mobNo = mobNo;
		this.dateJoin = dateJoin;
		this.dept = dept;
		this.managerId = managerId;
		this.leaveAvail = leaveAvail;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", email=" + email + ", mobNo=" + mobNo + ", dateJoin="
				+ dateJoin + ", dept=" + dept + ", managerId=" + managerId + ", leaveAvail=" + leaveAvail + "]";
	}

}
