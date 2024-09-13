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



import jakarta.ws.rs.Encoded;



@ManagedBean(name="ownerDetail")
@RequestScoped
@Entity
@Table(name="ownerDetail")
public class OwnerDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ownerId")
	private int ownerId;
	
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
	
	
	@Column(name="passingDate")
	private Date passingDate;
	
	@Column(name="degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private Login login;
	
	@Column(name="userId", insertable=false ,updatable=false)
	private int userId;
		
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	
	


	public Date getPassingDate() {
		return passingDate;
	}

	public void setPassingDate(Date passingDate) {
		this.passingDate = passingDate;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "OwnerDetail [ownerId=" + ownerId + ", ownerName=" + ownerName + ", gender=" + gender + ", email="
				+ email + ", panCardNo=" + panCardNo + ", aadharNo=" + aadharNo + ", passingYear=" + passingDate
				+ ", degree=" + degree + ", phoneNo=" + phoneNo + ", login=" + login + ", userId=" + userId + "]";
	}


	

}
