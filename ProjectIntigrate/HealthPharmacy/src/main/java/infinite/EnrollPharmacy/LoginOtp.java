package infinite.EnrollPharmacy;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="otp")
@RequestScoped
@Table(name="otp")
@Entity
public class LoginOtp {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="otpid")
	private int oId;
	@Column(name="userName")
	private String userName;
	@Column(name="otpNo")
	private int otpPass;
	@Column(name="status")
	private String status;
	@Column(name="sDate")
	private Date sDate;
	@Column(name="eDate")
	private Date eDate;
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getOtpPass() {
		return otpPass;
	}
	public void setOtpPass(int otpPass) {
		this.otpPass = otpPass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	
	
	
	
	
}
