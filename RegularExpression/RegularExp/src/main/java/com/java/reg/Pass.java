package com.java.reg;

import java.util.*;

public class Pass {
	
//	public static void main(String[] args) {
//		System.out.println(One_Time_Password(6));
//	}

	static char[] One_Time_Password(int len) {
		System.out.println("Generating password using random() : ");
		System.out.print("Your new password is : ");
		String numbers = "0123456789";
		Random rndm_method = new Random();
		char[] password = new char[len];
		for (int i = 0; i < len; i++) {
			password[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
		
		return password;
	}
}
