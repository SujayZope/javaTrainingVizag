package infinite.HealthPharmacy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "cDao")
@SessionScoped
public class PharmacyDetailDaoImpl implements PharmacyDetailDAO {

	// =======================================================
	static StringBuilder errorlist;
	static {
		errorlist = new StringBuilder();
	}
	// ===========================================================
	List<Gender> list2 = new ArrayList<>();

	List<LicenceType> list1 = new ArrayList<>();

	List<Degree> list3 = new ArrayList<>();

	// ===========================================================
	public List<LicenceType> getList1() {
		for (LicenceType licenceType : LicenceType.values()) {

			list1.add(licenceType);
		}

		return list1;
	}

	public void setList1(List<LicenceType> list1) {
		this.list1 = list1;
	}

	// ==========================================================
	public List<Gender> getList2() {
		for (Gender day : Gender.values()) {
			list2.add(day);
		}
		return list2;
	}

	public void setList2(List<Gender> list2) {
		this.list2 = list2;
	}

	// ==================================================================
	public List<Degree> getList3() {

		for (Degree degree : Degree.values()) {
			list3.add(degree);
		}
		return list3;
	}

	public void setList3(List<Degree> list3) {
		this.list3 = list3;
	}
	


	// To generate automatic registration number which is random


	public String generateRegistrationNo() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria cr = session.createCriteria(Pharmacy.class);
		cr.setProjection(Projections.max("regNo"));

		String str = (String) cr.uniqueResult();
		String sub = str.substring(1);
		int regNo = Integer.parseInt(sub);
		regNo++;
		session.close();
		return String.format("R%03d", regNo);
	}

	// ===================== Register Pharmacy=========================
	@Override
	public String AddPharmacyDetail(Login login, Pharmacy pharmacy, OwnerDetail ownerDetail) {
		String pwd = EntryptPassword.getCode(login.getPassword());
		
		login.setPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(login);
		ownerDetail.setLogin(login);
		session.save(ownerDetail);
		pharmacy.setOwnerDetail(ownerDetail);
		pharmacy.setStatus(Status.PENDING);
		session.save(pharmacy);
		trans.commit();
		session.close();
		return "Thanks.xhtml?faces-redirect=true";
	}

	// Show All records based on pending status
	@Override
	public List<ViewPending> showPharmacyPendingDAO() {
		// System.out.println("Control in side method");
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		String sql = "from ViewPending";
		Query query = session.createQuery(sql);
		System.out.println(query.list().size());
		System.out.println(query.list());
		

		return query.list();

	}

	// Session: to review individual records
	@Override
	public String actionOnPharma(int userId) {
		System.out.println("Entered user id is " + userId);
		ViewPending foundUser = searchByPharmaUserId(userId);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pharmacyInfo", foundUser);
		return "Action.xhtml?faces-context=true";
	}

	// Search All Pending records
	@Override
	public ViewPending searchByPharmaUserId(int userId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(ViewPending.class);
		cr.add(Restrictions.eq("userId", userId));
		ViewPending viewPending = (ViewPending) cr.uniqueResult();
		return viewPending;
	}

	// This method is calculate the difference between Passing year And approve
	// Year (In Year)
	public static long calculateTAT(ViewPending viewPending) {

		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Date date = new Date();

		String inputString1 = myFormat.format(date);
		System.out.println("Current date " + inputString1);

		Date timLine = viewPending.getPassingDate();

		String inputString2 = myFormat.format(timLine);
		System.out.println("Passing Date " + inputString2);

		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			long diff = date1.getTime() - date2.getTime();
			long diff1 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			System.out.println("Training Days: " + diff1);
			if (diff1 >= 365) {

				return diff1;
			} else {
				errorlist.append(
						" Registration only after one year of passing (You have to do minimum one year of traning)");
				return 0;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String validationDao(ViewPending viewPending) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		int pharmaId = viewPending.getUserId();
		Pharmacy pharma = searchByUserId(pharmaId);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		

		String email = viewPending.getEmail();
		System.out.println(email);

		// Validate license number
		String license = viewPending.getLicenceNo();
		LicenceType type = viewPending.getLicenceType();
		String isValidLicence = licenceValidate(license, type);

		String gst = validateGST(viewPending);

		// To calculate diff call TAT for calculate 1 min 1 year experience
		long diff = calculateTAT(viewPending);
		System.out.println("diff in passing date after return " + diff);

		// If block for GST, License Type and Registration year validation
		if (isValidLicence != null && diff != 0 && gst != null) {

			Transaction trans = session.beginTransaction();

			System.out.println("Valid");
			pharma.setStatus(Status.APPROVED);
			pharma.setRegNo(generateRegistrationNo());
			pharma.setApproveDate(new Date());
			Date adate = pharma.getExpireDate();
			adate = calculateExpireDate(10);
			pharma.setExpireDate(adate);

			System.out.println("reg number is " + pharma.getRegNo());

			session.update(pharma);

			trans.commit();
			session.close();

			String uName = generateUserName(viewPending);

			int otp = generateOTP(viewPending);

			Sendmail.sendInfo(email, "Pharmacy Registration Successfully",
					"Hello Mr/Mrs " + viewPending.getOwnerName() + " Your Pharmacy " + pharma.getPharmaName()
							+ "Is Registered Successfully " + " Your Registration Number Is:- " + pharma.getRegNo()
							+ " and It is valid Up to:-  " + pharma.getExpireDate().toGMTString());

			// Log-In Credentials
			Sendmail.sendInfo(email, "Log-In Credentials",
					"Your User Name Is " + uName + "(for security " + "purpose you will recive OTP through other mail");

			Sendmail.sendInfo(email, "Log-In Credentials", "Your OTP Is " + otp);

			return "Approve.xhtml?faces-context=true";

		} else {
			System.out.println("inside my antique block");
			System.out.println(pharma.getStatus());

			if (pharma.getStatus().equals(Status.PENDING)) {

				Transaction trans = session.beginTransaction();
				Date timeLine = calculateTimlineDate(1);

				pharma.setTimeLineDate(timeLine);
				System.out.println(timeLine);
				pharma.setStatus(Status.REWORK);
				session.update(pharma);

				trans.commit();

				// return "Reject.xhtml?faces-context=true";
				Sendmail.sendInfo(email, "Rework Your application",
						"due to" + errorlist.toString() + " Your Pharmacy Registration "
								+ "Request is Revert back to you " + "please confirm and try again before "
								+ timeLine.toGMTString());

				return "Reject.xhtml?faces-context=true";
			} else if (pharma.getStatus().equals(Status.REWORK)) {
				System.out.println("inside my rework block");
				rejectPharmacy(viewPending);
				return "Reject.xhtml?faces-context=true";

			}
		}

		return "----------------";
	}

	static String extractInt(String str) {
		// Replacing every non-digit number
		// with a space(" ")
		str = str.replaceAll("[^0-9]", ""); // regular expression

		// Replace all the consecutive white
		// spaces with a single space
		str = str.replaceAll(" +", " ");

		if (str.equals(""))
			return "-1";

		return str;
	}

	// Calculat sum of all digit present in GST Number
	public static int sumDigits(String c) {
		int sum = 0;
		for (int i = 0; i < c.length(); i++) {
			if (Character.isDigit(c.charAt(i)))
				sum = sum + Character.getNumericValue(c.charAt(i));
		}
		// System.out.println("Sum of all the digit present in Pan : "+sum);
		return sum;
	}

	// To validate Pan card Pattern
	public static String sendPan(String panCardNo) {
		if (isValidPanCardNo(panCardNo) == true) {
			return panCardNo;
		}
		errorlist.append(" Invalid PAN Card Number");
		return null;
	}

	// Validation of PAN Card
	public static boolean isValidPanCardNo(String panCardNo) {
		// to check valid PAN Card number.
		// [A-Z]{5}= first 5 char is A-Z, [0-9]{4}= next 4 is btw
		// 0-9,[A-Z]{1}=last one is A-Z

		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

		Pattern p = Pattern.compile(regex);

		if (panCardNo == null) {
			return false;
		}

		Matcher m = p.matcher(panCardNo);
		return m.matches();
	}

	// For pharmacy
	public Pharmacy searchByUserId(int pharmaId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Pharmacy.class);
		cr.add(Restrictions.eq("pharmaId", pharmaId));
		Pharmacy pharma = (Pharmacy) cr.uniqueResult();
		session.close();
		return pharma;
	}

	// For login
	public Login searchLoginUserId(int userId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userId", userId));
		Login login = (Login) cr.uniqueResult();
        session.close();
		return login;
	}

	// ================== License Validation===================

	public static String licenceValidate(String license, LicenceType type) {

		String prefix = license.substring(0, 2);
		String ty = type.toString();

		if ("PHARMACIST".equals(ty) && prefix.equals("PH")) {

			System.out.println("Simple pharmacist");
			return license;
		} else if ("PHARMACY_TECHNICIAN".equals(ty) && prefix.equals("PT")) {

			System.out.println("Pharmacy techanician");
			return license;
		} else if ("RETAIL_DRUG_STORE_PERMIT".equals(ty) && prefix.equals("DS")) {

			System.out.println("Retail drug store");

			return license;
		} else if ("WHOLESALE_DRUG_STORE_PERMIT".equals(ty) && prefix.equals("WS")) {

			System.out.println("Wholesale drug store");
			return license;
		} else {

			errorlist.append(" Invalid Licence Number");
			System.out.println("No match found");
			return null;
		}

	}

	// Calculate Expire date for approved pharmacy
	@Override
	public Date calculateExpireDate(int year) {
		DateFormat datefor = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(cal.YEAR, year);

		return cal.getTime();
	}

	// Calculate Time Line (30 days)
	public Date calculateTimlineDate(int month) {
		DateFormat datefor = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(cal.MONTH, month);

		return cal.getTime();
	}

	// To Add comment for rejected pharmacy
	public String addComment(ViewPending viewPending) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		int userId = viewPending.getUserId();
		Pharmacy pharmacy = searchByUserId(userId);
		System.out.println("pharma Id " + userId);
		System.out.println(pharmacy);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		

		Transaction trans = session.beginTransaction();
		String cm = viewPending.getComment();
		System.out.println("comment is " + cm);
		pharmacy.setComment(cm);

		session.update(pharmacy);
		trans.commit();
		session.close();
		return "CommentAdded.xhtml?faces-context=true";
	}

	// For front end color

	public long calculatBalForColor(ViewPending viewPending) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		/*SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();*/

		if (viewPending.getStatus().equals(Status.REWORK)) {
			int userId = viewPending.getUserId();

			Pharmacy pharmacy = searchByUserId(userId);

			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			Date date = new Date();

			String inputString1 = myFormat.format(date);
			System.out.println("Current date for color " + inputString1);

			Date timLine = pharmacy.getTimeLineDate();

			String inputString2 = myFormat.format(timLine);
			System.out.println("Time Line Date color " + inputString2);

			try {
				Date date1 = myFormat.parse(inputString1);
				Date date2 = myFormat.parse(inputString2);
				long diff = date2.getTime() - date1.getTime();
				long diff2=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
				System.out.println ("Days: " + TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS));
				return diff2;
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}

	// ===============Validate GST Number=====================
	@Override
	public String validateGST(ViewPending viewPending) {

		String vGst = viewPending.getGstNo();
		int vGstLength = vGst.length();

		System.out.println("length of GST No :-" + vGstLength);
		
		if (vGstLength == 15) {

			boolean result = Pattern.matches("[0-9]{2}", vGst.substring(0, 2));

			System.out.println("Is it first two num is digit: " + result);// true

			int sum = 0;
			if (result == true) {
				sum += Integer.parseInt(String.valueOf(vGst.charAt(0)));
				sum += Integer.parseInt(String.valueOf(vGst.charAt(1)));
				System.out.println("sum of first two digit " + sum);
			}

			// PAN Number extracted from GST number
			String pan = vGst.substring(2, 12);

			// Registered PAN Number After Validation
			String demoPan = sendPan(viewPending.getPanCardNo());

			System.out.println("Pan no from databaase:- " + demoPan);
			System.out.println("Pan Number from GST:- " + pan);

			System.out.println("how many didgit in pan" + sumDigits(pan));
			sum += sumDigits(pan);
			sum++;

			System.out.println("sum of numbers from GST:- " + sum);
			
			int num = Integer.parseInt(String.valueOf(vGst.substring(vGst.length() - 1)));
			
			System.out.println("last number:- " + num);

			if (sum == num && pan.equals(demoPan)) {

				return vGst;

			} else {

				errorlist.append(" Invalid GST Number");
				return null;
			}
		} else {
			errorlist.append(" Invalid GST Number");
			System.out.println("length is leass than 15");
			return null;
		}

	}

	// Generate User Name
	public String generateUserName(ViewPending viewPending) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		int userId = viewPending.getUserId();
		Login login = searchLoginUserId(userId);
		System.out.println("Login Id " + userId);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		// System.out.println(login);
		Transaction trans = session.beginTransaction();
		String un = viewPending.getOwnerName().substring(0, 2).toLowerCase();
		String ph = viewPending.getPhoneNo().substring(0, 4);

		String username = un.concat(ph);

		System.out.println("user name " + username);

		login.setUserName(username);

		session.update(login);
		trans.commit();
		System.out.println(login);
		return username;

	}
	// Generate OTP

	public int generateOTP(ViewPending viewPending) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		int userId = viewPending.getUserId();

		Login login = searchLoginUserId(userId);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		// System.out.println("Login Id " + userId);
		// System.out.println(login);

		Random r = new Random(System.currentTimeMillis());
		int otp = (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);

		//String op = Integer.toString(otp);

		//System.out.println("OTP Is " + op);

		Transaction trans = session.beginTransaction();
		login.setOtp(otp);
		System.out.println(login);

		session.update(login);
		trans.commit();

		return otp;

	}

	// Reject Status if balance days in timeline is less than 0

	public ViewPending rejectPharmacy(ViewPending viewPending) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		int userId = viewPending.getUserId();

		String email = viewPending.getEmail();
		Pharmacy pharmacy = searchByUserId(userId);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		

		long balDay = calculatBalDays(viewPending);

		if (balDay <= 0) {
			Transaction trans = session.beginTransaction();
			pharmacy.setStatus(Status.REJECT);
			session.update(pharmacy);

			trans.commit();

			// return "Reject.xhtml?faces-context=true";
			Sendmail.sendInfo(email, "Pharmacy Application Is Rejected",
					" Hello Mr/Mrs " + viewPending.getOwnerName()
							+ " Sorry to inform you but Within given Time Line you are not updated your pharmacy "
							+ "details therefor Your Pharmacy " + viewPending.getPharmaName() + " Is rejected");

		}

		return viewPending;

	}

	// Calculate balance days for TimeLine
	public long calculatBalDays(ViewPending viewPending) {

		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Date date = new Date();

		String inputString1 = myFormat.format(date);
		System.out.println("Current date " + inputString1);

		Date timLine = viewPending.getTimeLineDate();

		String inputString2 = myFormat.format(timLine);
		System.out.println("Time Line Date " + inputString2);

		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			long diff = date2.getTime() - date1.getTime();
			long diff2=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			System.out.println("Days: " +diff2);
			return diff2;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;

	}

	

}
