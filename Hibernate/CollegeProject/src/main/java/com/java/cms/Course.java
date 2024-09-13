package com.java.cms;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="course")
@SessionScoped
@Entity
@Table(name="courselist")
public class Course {
	
	@Id
	@Column(name="courseno")
	private String courseNo;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="startDate")
	private Date sDate;
	
	@Column(name="endDate")
	private Date eDate;
	
	@Column(name="HOD")
	private String hod;

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	

}
