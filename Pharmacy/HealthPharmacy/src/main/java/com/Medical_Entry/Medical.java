package com.Medical_Entry;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="medical")
@SessionScoped
@Entity
@Table(name="medicine_sale")
public class Medical {
	
	@Id
	@Column(name="Bill_No")
	private int bill_no;
	
	@Column(name="Medical_ID")
	private String medical_id;
	
	@Column(name="Hospital_Id")
	private String hospital_id;
	
	@Column(name="Dr_Id")
	private String dr_id;
	
	@Column(name="Item_Name")
	private String medicin_name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Sale_Date")
	private Date sale_date;
	
	@Column(name="Amount")
	private double amount;
	
	@Column(name="Petiant_Id")
	private String patientid;
	
	@Column(name="BatchNo")
	private String batchno;
	
	@Column(name="ExpiryDate")
	private Date expDate;
	
	@Column(name="HSN")
	private int hsn;
	
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBill_no() {
		return bill_no;
	}

	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getHsn() {
		return hsn;
	}

	public void setHsn(int hsn) {
		this.hsn = hsn;
	}

	public String getMedical_id() {
		return medical_id;
	}

	public void setMedical_id(String medical_id) {
		this.medical_id = medical_id;
	}

	public String getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(String hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getDr_id() {
		return dr_id;
	}

	public void setDr_id(String dr_id) {
		this.dr_id = dr_id;
	}

	public String getMedicin_name() {
		return medicin_name;
	}

	public void setMedicin_name(String medicin_name) {
		this.medicin_name = medicin_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	@Override
	public String toString() {
		return "Medical [bill_no=" + bill_no + ", medical_id=" + medical_id + ", hospital_id=" + hospital_id
				+ ", dr_id=" + dr_id + ", medicin_name=" + medicin_name + ", price=" + price + ", quantity=" + quantity
				+ ", sale_date=" + sale_date + ", amount=" + amount + ", patientid=" + patientid + ", batchno="
				+ batchno + ", expDate=" + expDate + ", hsn=" + hsn + "]";
	}

	public Medical(String medicin_name, double price, int quantity, double amount, String batchno,Date expDate, int hsn ) {
		super();
		this.medicin_name = medicin_name;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.batchno = batchno;
		this.expDate = expDate;
		this.hsn = hsn;
	}

	public Medical() {
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
	
}
