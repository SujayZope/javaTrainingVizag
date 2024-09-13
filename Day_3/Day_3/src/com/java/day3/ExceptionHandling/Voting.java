package com.java.day3.ExceptionHandling;

import java.util.Scanner;

public class Voting {
	
	public void check(int age) throws VotingException{
		if(age < 18){
			throw new VotingException("Yow are not Elligible for Voting...");
		}
		System.out.println("You can vote...");
	}
	public static void main(String[] args) {
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age  ");
		age = sc.nextInt();
		Voting obj = new Voting();
		try {
			obj.check(age);
		} 
		catch(VotingException e){
			e.printStackTrace();
		}
		
	}

}
