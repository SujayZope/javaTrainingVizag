package infinite.LoginPharmacy;

import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;
import infinite.HealthPharmacy.Pharmacy;

public interface LoginDao {

	String validateMe(Login login);

	Login searchByLoginUser(String userName);

	OwnerDetail searchOwnerDetailByloginId(int userId);
	
	Pharmacy searchPharmacyByownerId(int ownerId);

	String checkUsername(String username);

	String sendOtp(String email, String userName);

	String ResendOtp(String email, String userName);

	String validateOtp(Login login, String sessionUsername);

	String resetPassword(Login login);

	Login searchByUserName(String username);

	
}
