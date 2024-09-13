package infinite.HealthPharmacy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="viewPending")
@Immutable
public class ViewPending {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	
	@Column(name="pharmaId")
	private int pharmaId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="ownerName")
	private String ownerName;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="email")
	private String email;
	
	

	@Column(name="panCardNo")
	private String panCardNo;
	
	
	@Column(name="aadharNo")
	private String aadharNo;
	
	

	
	@Column(name="degree")
	private String degree;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
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

	@Column(name="licenceType")
	@Enumerated(EnumType.STRING)
	private LicenceType licenceType;
	
	@Column(name="passingDate")
	private Date passingDate;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="timeLineDate")
	private Date timeLineDate;
	
	

	public Date getTimeLineDate() {
		return timeLineDate;
	}

	public void setTimeLineDate(Date timeLineDate) {
		this.timeLineDate = timeLineDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public int getPharmaId() {
		return pharmaId;
	}

	public void setPharmaId(int pharmaId) {
		this.pharmaId = pharmaId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
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

	public LicenceType getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(LicenceType licenceType) {
		this.licenceType = licenceType;
	}



	public Date getPassingDate() {
		return passingDate;
	}

	public void setPassingDate(Date passingDate) {
		this.passingDate = passingDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
