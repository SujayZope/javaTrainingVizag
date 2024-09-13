package com.Medical_Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="procedure")
@SessionScoped
@Entity
@Table(name="procedure1")
public class Procedure {
	
	@Id
	@Column(name="procedureID")
	private String procedureiD;
	
	@Column(name="recipientId")
	private String recipientid;

	public String getProcedureiD() {
		return procedureiD;
	}

	public void setProcedureiD(String procedureiD) {
		this.procedureiD = procedureiD;
	}

	public String getRecipientid() {
		return recipientid;
	}

	public void setRecipientid(String recipientid) {
		this.recipientid = recipientid;
	}

	@Override
	public String toString() {
		return "Procedure [procedureiD=" + procedureiD + ", recipientid=" + recipientid + "]";
	}
	
	

}
