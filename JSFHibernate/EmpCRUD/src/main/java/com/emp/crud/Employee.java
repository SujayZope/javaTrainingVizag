package com.emp.crud;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="emp")
@SessionScoped
@Entity
@Table(name="employ")

public class Employee {

	@Id
	@Column(name="Empno")
	private int empId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Dept")
	private String dept;
	
	@Column(name="Desig")
	private String desig;
	
	@Column(name="Basic")
	private int basic;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	
	
	
	
	
}
