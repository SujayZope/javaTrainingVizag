package infinite.EnrollPharmacy;

import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;
import infinite.HealthPharmacy.Pharmacy;

public interface PharmacyEnrollDAO {
	
	public String AddPharmacyDetail(Login login,Pharmacy pharmacy,OwnerDetail ownerDetail);

	public String updatePharmacyDetails(Pharmacy pharmacy, OwnerDetail ownerDetail);

	public String checkUser(LoginOtp l, String email);

	public OwnerDetail searchOwnerByEmail(String email);

	public long otpGenerate(String userName);

	public String authenticate(String email);

	public String searchOwner(String email);

}
