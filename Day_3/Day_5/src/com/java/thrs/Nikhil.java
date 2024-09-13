package com.java.thrs;

public class Nikhil implements Runnable {
	Data data;
	Nikhil(Data data){
		this.data=data;
	}
	
	@Override
	public void run() {
		data.dispMsg("Nikhil");
	}


}
