package com.infinite.day_2;

public class Quiz1 {

	public void show(Object ob){
		if(ob=="ABC"){
			System.out.println("Correct...");
		}else{
			System.out.println("Incorrect...");
		}
	}
	public static void main(String[] args) {
		String ob="ABC";
		new Quiz1().show(ob);

	}

}
