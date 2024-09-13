package com.Medical_Entry;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="bill_b")
@SessionScoped
@Entity
@Table(name="medical_bill")
public class Medical_Bill {
	@Id
	@Column(name="bill_Id")
	private int bill_no;
	
	@Column(name="stockId")
	private int stock_id;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="batchNo")
	private String batchno;
	
	@Column(name="patientId")
	private String patientid;
	
	@Column(name="HSN")
	private int hsn;
	
	@Column(name="hospitalName")
	private String hospital_name;
	
	@Column(name="medical_Name")
	private String medical_name;
	
	@Column(name="saledate")
	private Date sale_date;
	
	@Column(name="expdate")
	private Date expdate;
	
	@Column(name="amount")
	private double amount;
	
	
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	public int getBill_no() {
		return bill_no;
	}

	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public int getHsn() {
		return hsn;
	}

	public void setHsn(int hsn) {
		this.hsn = hsn;
	}

	

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getMedical_name() {
		return medical_name;
	}

	public void setMedical_name(String medical_name) {
		this.medical_name = medical_name;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	@Override
	public String toString() {
		return "Medical_Bill [bill_no=" + bill_no + ", stock_id=" + stock_id + ", quantity=" + quantity + ", batchno="
				+ batchno + ", patientid=" + patientid + ", hsn=" + hsn + ", hospital_name=" + hospital_name
				+ ", medical_name=" + medical_name + ", sale_date=" + sale_date + ", expdate=" + expdate + "]";
	}

	
	



	

	
	
	
	

}
