package com.java.thrs;

public class Subodh implements Runnable{
	
	Data data;
	Subodh(Data data){
		this.data=data;
	}
	
	@Override
	public void run() {
		data.dispMsg("Subodh");
	}


}
