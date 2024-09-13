package com.java.abs;

public class MainProg {

	public static void main(String[] args) {
		String topic ="Java";
		AbstractFactory obj = new TrainingFactory();
		Training result = obj.getDetails(topic);
		System.out.println(result.getClass().getSimpleName());
		System.out.println(result.getTrainingDetails());
	}
}
