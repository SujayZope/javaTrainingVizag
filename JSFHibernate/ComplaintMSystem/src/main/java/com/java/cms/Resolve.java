package com.java.cms;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name = "resolve")
@SessionScoped
@Entity
@Table(name = "resolve")
public class Resolve {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resolveID")
	private int resolveID;

	@Column(name = "complaintId")
	private String complaintId;

	@Column(name = "complaintDate")
	private Date complaintDate;

	@Column(name = "resolveDate")
	private Date resolveDate;

	@Column(name = "resolvedBy")
	private String resolvedBy;

	@Column(name = "comments")
	private String comments;

	public int getResolveID() {
		return resolveID;
	}

	public void setResolveID(int resolveID) {
		this.resolveID = resolveID;
	}

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public Date getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Resolve(String complaintId, Date complaintDate, Date resolveDate, String resolvedBy, String comments) {

		this.complaintId = complaintId;
		this.complaintDate = complaintDate;
		this.resolveDate = resolveDate;
		this.resolvedBy = resolvedBy;
		this.comments = comments;
	}

	public Resolve() {

	}

	@Override
	public String toString() {
		return "Resolve [complaintId=" + complaintId + ", complaintDate=" + complaintDate + ", resolveDate="
				+ resolveDate + ", resolvedBy=" + resolvedBy + ", comments=" + comments + "]";
	}

}
