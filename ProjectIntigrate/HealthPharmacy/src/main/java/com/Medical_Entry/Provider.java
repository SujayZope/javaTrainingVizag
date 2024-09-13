package com.Medical_Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="provider")
@SessionScoped
@Entity
@Table(name="provider")
public class Provider {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pId")
	private String providerid;
	
	@Column(name="Hospital")
	private String hospital;

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Provider [providerid=" + providerid + ", hospital=" + hospital + "]";
	}
	
	

}
