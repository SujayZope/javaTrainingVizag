
package com.java.college;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@ManagedBean(name = "feedback")
@SessionScoped
@Entity
@Table(name = "feedback")

public class Feedback {

	@Id
	@Column(name = "FID")
	private String fid;

	@Column(name = "StudentName")
	private String studentName;

	@Column(name = "instructor")
	private String instructor;

	@Column(name = "subject")
	private String subject;

	@Column(name = "FbValue")
	private String fbValue;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFbValue() {
		return fbValue;
	}

	public void setFbValue(String fbValue) {
		this.fbValue = fbValue;
	}

	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", studentName=" + studentName + ", instructor=" + instructor + ", subject="
				+ subject + ", fbValue=" + fbValue + "]";
	}

}
