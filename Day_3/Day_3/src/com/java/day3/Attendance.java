package com.java.day3;

public class Attendance {
	
	public void show(int dayNo, String...attendance){
		System.out.println("Day  " +dayNo);
		for (String s : attendance){
			System.out.println(s + " ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		Attendance obj =new Attendance();
		
		obj.show(1, "Makarand","Partha","Chetan");
		obj.show(2, "Yogesh","Chandan","Gokul","Lata","Jay");
		obj.show(3, "Sanket","Subodh");
		obj.show(4, "Nikhil","Sarthak","Akash","Deepak","Avesh","Ganesh");
		obj.show(5);
	}

}
