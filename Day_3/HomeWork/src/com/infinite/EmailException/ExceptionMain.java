package com.infinite.EmailException;

import java.util.Scanner;

public class ExceptionMain {
	
	
	public static boolean isValid(String str) throws InvalidEmailException, InvlidUserException{
		
		boolean valid=true;
		
		if(!str.contains("@")){
			valid=false;
			throw new InvalidEmailException("email must contain @ sysmbol");
		}
	
		String[] temp=str.split("@");
		if(temp[0].length()>=12){
			valid=false;
			
			throw new InvlidUserException("user name cannot be greater than 12 cahracters");
		}
		
		return valid;
	
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("enter emailid");
		
		String str=sc.next();
		
		try {
			if(isValid(str)){
				System.out.println("your mail id is "+str);
			}
		} catch (InvalidEmailException | InvlidUserException e) {
			System.out.println(e);
		}
		
		
		
		
	}

}

