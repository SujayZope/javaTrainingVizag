package com.java.pms;

public interface LoginDao {

	//String authenticate(Login login);

	String validateMe(Login login);
	
	String addUser(Login login);
	
	String validateOtp(Login login);
	
	Login searchByLoginUser(String userName);
	
	String otp(Login login);

	String checkUsername(String username);

}
