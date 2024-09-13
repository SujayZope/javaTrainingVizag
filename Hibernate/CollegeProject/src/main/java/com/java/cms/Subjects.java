package com.java.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="subject")
@SessionScoped
@Entity
@Table(name="subjects")
public class Subjects {
	
	@Id
	@Column(name="subjectId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subId;
	
	@Column(name="year")
	private int year;
	
	@Column(name="instructor")
	private String instructor;
	
	@Column(name="subject")
	private String sub;
	
	@Column(name="theory")
	private int theory;
	
	@Column(name="practical")
	private int pract;
	
	
	

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public int getTheory() {
		return theory;
	}

	public void setTheory(int theory) {
		this.theory = theory;
	}

	public int getPract() {
		return pract;
	}

	public void setPract(int pract) {
		this.pract = pract;
	}
	
	

}
