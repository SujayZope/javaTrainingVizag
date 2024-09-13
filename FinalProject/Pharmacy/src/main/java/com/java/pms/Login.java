package com.java.pms;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@ManagedBean(name="login")
@SessionScoped
@Entity
@Table(name="login")

public class Login {
	
	@Id
	@Column(name="loginId")
	private int loginId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="eMail")
	private String eMail;
	
	@Column(name="passCode")
	private String passCode;
	
	@Column(name="otpNo")
	private long otpNo;
	
	@Column(name="otpExpiryTime")
	private Date otpExpiryTime;
	
	@Column(name="PassExpiryTime")
	private Date PassExpiryTime;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassCode() {
		return passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public long getOtpNo() {
		return otpNo;
	}

	public void setOtpNo(long otpNo) {
		this.otpNo = otpNo;
	}

	public Date getOtpExpiryTime() {
		return otpExpiryTime;
	}

	public void setOtpExpiryTime(Date otpExpiryTime) {
		this.otpExpiryTime = otpExpiryTime;
	}

	public Date getPassExpiryTime() {
		return PassExpiryTime;
	}

	public void setPassExpiryTime(Date passExpiryTime) {
		PassExpiryTime = passExpiryTime;
	}

	
	
	

	
	

}
