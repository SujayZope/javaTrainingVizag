package com.infinite.day1;

public class OddEven {
	public void check(int num){
		
		if(num%2==0)
		{
			System.out.println("Number is Even " +num);
		}else{
			System.out.println("Number is Odd  "+num);
		}
	}

	public static void main(String[] args) {
		int num=17;
		new OddEven().check(num);

	}

}
