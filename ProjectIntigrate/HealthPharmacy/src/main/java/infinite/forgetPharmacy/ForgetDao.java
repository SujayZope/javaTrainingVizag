package infinite.forgetPharmacy;

import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;

public interface ForgetDao {

	Login searchByUserName(String username);
	OwnerDetail searchPharmacyByloginId(int userId);
    String checkUsername(String username);
	String sendOtp(String email, String userName);
	String validateOtp(Login login, String sessionUsername);
	String ResendOtp(String email, String userName);
	String ForgetPassword(String username, String password);
	

	
	
	
}
