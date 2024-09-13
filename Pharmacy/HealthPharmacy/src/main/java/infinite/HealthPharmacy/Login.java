package infinite.HealthPharmacy;



import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean(name="login")
@SessionScoped
@Entity
@Table(name="login")
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="otp")
	private long otp;
	
	@Column(name="otpexptime")
	private Date otpexptime;

	
	@Column(name="passexpirytime")
	private Date PassExpiryTime;

	@Column(name="flag")
	private String flag;

	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getOtp() {
		return otp;
	}


	public void setOtp(long otp) {
		this.otp = otp;
	}


	public Date getOtpexptime() {
		return otpexptime;
	}


	public void setOtpexptime(Date otpexptime) {
		this.otpexptime = otpexptime;
	}


	public Date getPassExpiryTime() {
		return PassExpiryTime;
	}


	public void setPassExpiryTime(Date passExpiryTime) {
		PassExpiryTime = passExpiryTime;
	}


	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName + ", password=" + password + ", otp=" + otp
				+ ", otpexptime=" + otpexptime + ", PassExpiryTime=" + PassExpiryTime + ", flag=" + flag + "]";
	}


	

	
	
}
