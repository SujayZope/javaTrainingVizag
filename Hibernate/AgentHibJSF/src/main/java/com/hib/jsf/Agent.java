package com.hib.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="agent")
@SessionScoped
@Entity
@Table(name="agent")
public class Agent {
	
	@Id
	@Column(name="AgentID")
	private int agentid;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="City")
	private String city;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER")
	private Gender gender;
	
	@Column(name="MaritalStatus")
	private int maritalstatus;
	
	@Column(name="Premium")
	private double premium;

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Agent [agentid=" + agentid + ", name=" + name + ", city=" + city + ", gender=" + gender
				+ ", maritalstatus=" + maritalstatus + ", premium=" + premium + "]";
	}
	
	
	
}
