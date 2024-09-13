package infinite.HealthPharmacy;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;



@ManagedBean(name="pharmacy")
@RequestScoped
@Entity
@Table(name="pharmacy")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pharmaId")
	private int pharmaId;
	
	@Column(name="moduleType")
	private String moduleType;
	
	@Column(name="pharmaName")
	private String pharmaName;
	
	@Column(name="regNo")
	private String regNo;
	
	@Column(name="licenceNo")
	private String licenceNo;
	
	@Column(name="gstNo")
	private String gstNo;
	
	@Column(name="shopActNo")
	private String shopActNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pinCode")
	private int pinCode;
	
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="licenceType")
	@Enumerated(EnumType.STRING)
	private LicenceType licenceType;
	
	@Column(name="approveDate")
	private Date approveDate;
	
	@Column(name="expireDate")
	private Date expireDate;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="timeLineDate")
	private Date timeLineDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ownerId")
	private OwnerDetail ownerDetail;
  
	
	
	@Column(name="ownerId",insertable=false,updatable=false)
	private int ownerId;
	
	
	
	
	
	
	
	
	

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getPharmaId() {
		return pharmaId;
	}

	public void setPharmaId(int pharmaId) {
		this.pharmaId = pharmaId;
	}

	public String getPharmaName() {
		return pharmaName;
	}

	public void setPharmaName(String pharmaName) {
		this.pharmaName = pharmaName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getShopActNo() {
		return shopActNo;
	}

	public void setShopActNo(String shopActNo) {
		this.shopActNo = shopActNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public OwnerDetail getOwnerDetail() {
		return ownerDetail;
	}

	public void setOwnerDetail(OwnerDetail ownerDetail) {
		this.ownerDetail = ownerDetail;
	}
	
	

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}




	public LicenceType getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(LicenceType licenceType) {
		this.licenceType = licenceType;
	}
	
	

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	

	public Date getTimeLineDate() {
		return timeLineDate;
	}

	public void setTimeLineDate(Date timeLineDate) {
		this.timeLineDate = timeLineDate;
	}

	@Override
	public String toString() {
		return "Pharmacy [pharmaId=" + pharmaId + ", moduleType=" + moduleType + ", pharmaName=" + pharmaName
				+ ", regNo=" + regNo + ", licenceNo=" + licenceNo + ", gstNo=" + gstNo + ", shopActNo=" + shopActNo
				+ ", address=" + address + ", pinCode=" + pinCode + ", status=" + status + ", licenceType="
				+ licenceType + ", approveDate=" + approveDate + ", expireDate=" + expireDate + ", comment=" + comment
				+ ", timeLineDate=" + timeLineDate + ", ownerDetail=" + ownerDetail + "]";
	}



}
