package com.java.abs1;

public class MobileFactory extends AbstractFactory {

	@Override
	public Mobile getDetails(String topic) {
		if (topic.equals("Iphone")) {
			return new IPhone();
		}
		if (topic.equals("Samsung")) {
			return  new Samsung();
		}
		if (topic.equals("Oneplus")) {
			return  new OnePlus();
		}
		return null;
	}

}
