package com.infinite.Interface;

public class IntEx {
	
	public static void main(String[] args) {
		Itraining[] arr= new Itraining[] {
			new Pavan(), new Sarathi(),
			new Swetha()
		};
		
		for(Itraining i : arr){
			i.name();
			i.email();
		}
	}
}
