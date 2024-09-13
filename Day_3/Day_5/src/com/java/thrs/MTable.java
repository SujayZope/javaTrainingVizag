package com.java.thrs;

public class MTable {
	
	synchronized void dispTable(int n){
		int p;
		for(int i=1;i<=10;i++){
			p=n*i;
			System.out.println(n + " * " + i + " = "+p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}


