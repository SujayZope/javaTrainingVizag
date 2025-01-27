package infinite.LoginPharmacy;

import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;

public interface LoginDao {

	String validateMe(Login login);

	Login searchByUserName(String username);
	
	OwnerDetail searchPharmacyByloginId(int userId);
	
	String checkUsername(String username);
	
	String validateOtp(Login login,String sessionUsername);
	
	String ResendOtp(String email,String userName);
	
	String sendOtp(String email,String userName);
	
}
