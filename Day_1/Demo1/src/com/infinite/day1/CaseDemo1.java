package com.infinite.day1;

public class CaseDemo1 {

	public void show(int sno){
		switch(sno){
		case 1 :
			System.out.println("Hi I am Yogesh");
			break;
		case 2 :
			System.out.println("Hi I am Nikhil");
			break;
		case 3 :
			System.out.println("Hi I am Ritesh");
			break;
		case 4 :
			System.out.println("Hi I am Aniket");
			break;
		case 5 :
			System.out.println("Hi I am Deepak");
			break;
		default :
			System.out.println("Invalid choice...");
			}
	}
	public static void main(String[] args) {
		int sno=3;
		new CaseDemo1().show(sno);
		

	}

}