package com.java.thrs;

public class Odd extends Thread{
	
	
	@Override
	public void run() {
		
		for(int i=1;i<20;i+=2){
			System.out.println("Odd  "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
