package infinite.HealthPharmacy;

import java.util.Date;
import java.util.List;

public interface PharmacyDetailDAO {
	
	String AddPharmacyDetail(Login login,Pharmacy pharmacy,OwnerDetail ownerDetail);
	
	public List<ViewPending> showPharmacyPendingDAO();
	
	String actionOnPharma(int userId);
	
	public ViewPending searchByPharmaUserId(int pharmaId);
	
	public String validationDao(ViewPending viewPending);
	
	public Date calculateExpireDate(int year);
	
	public String validateGST(ViewPending viewPending);
	
	//=========================================================
	
	


}
