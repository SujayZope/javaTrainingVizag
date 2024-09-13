package infinite.HealthPharmacy;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="LoginHistory")
@ManagedBean(name="LoginHistory")
@RequestScoped
public class LoginHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="historyId")
	private int historyId;

	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passCode")	
	private String passCode;
	
	@Column(name="createdOn")
	private Timestamp createdOn; 
	
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassCode() {
		return passCode;
	}
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
	
	@Override
	public String toString() {
		return "LoginHistory [historyId=" + historyId + ", userName=" + userName + ", passCode=" + passCode
				+ ", createdOn=" + createdOn + "]";
	}
	
}
