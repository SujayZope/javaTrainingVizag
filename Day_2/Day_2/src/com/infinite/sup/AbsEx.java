package com.infinite.sup;

public class AbsEx {
	public static void main(String[] args) {
		Training[] arr = new Training[]{
				new Chetan(),
				new Yogita(),
				new Darshan()
		};
		for (Training training : arr){
			training.name();
			training.email();
		}
	}

}
