package com.infinite.day1;

public class CaseDemo2 {
	public void show(String dayNames){
		switch (dayNames){
		case "Sunday" :
			System.out.println();
			break;
		case "Monday" :
			System.out.println("");
			break;
		case "Tuesday" :
			System.out.println();
			break;
		case "Wednesday" :
			System.out.println();
			break;
		case "Thursday" :
			System.out.println();
			break;
		case "Fryday" :
			System.out.println();
			break;
		case "Saturday" :
			System.out.println();
			break;
		}
	}

	public static void main(String[] args) {
		String dayNames="Monday";
		new CaseDemo2().show(dayNames);

	}

}
