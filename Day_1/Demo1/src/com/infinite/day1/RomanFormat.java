package com.infinite.day1;

public class RomanFormat {
	
	public static void intToRoman(int num)   
	{  
	System.out.println("Integer: " + num);  
	int[] values = {10000,9000,5000,4000,3000,2000,1000,900,500,400,100,90,50,40,10,9,5,4,1};  
	String[] romanLetters = {"X̅","I̅X̅","V̅","MV̅","MMM","MM","M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
	StringBuilder roman = new StringBuilder();  
	for(int i=0;i<values.length;i++)   
	{  
	while(num >= values[i])   
	{  
	num = num - values[i];  
	roman.append(romanLetters[i]);  
	}  
	}  
	System.out.println("Corresponding Roman Numerals is: " + roman.toString());  
	}  
	public static void main(String args[])   
	{ 
		for(int i=1;i<=10000;i++){
			intToRoman(i);  
		}
	}  

}
