package com.infinite.day_2;

public class Cricket {
	static int score;
	
	public void increment(int x){
		score+=x;
		
	}
	
	public static void main(String[] args) {
		Cricket obj1 = new Cricket();
		Cricket obj2 = new Cricket();
		Cricket obj3 = new Cricket();
		
		obj1.increment(42);
		obj2.increment(32);
		obj3.increment(76);
		
		System.out.println("Total Score  " +Cricket.score);
	}

}
