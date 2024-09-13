package com.java.thrs;

public class Chetan implements Runnable{
	
	Data data;
	Chetan(Data data){
		this.data=data;
	}
	
	@Override
	public void run() {
		data.dispMsg("Chetan");
	}

}
