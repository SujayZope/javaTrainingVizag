package com.infinite.Interface.Practice;

import com.infinite.Interface.MultiInh;

public class Test implements IOne,ITwo,IThree {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		IOne.super.show();
		ITwo.super.show();
		IThree.super.show();
	}
	public static void main(String[] args) {
		new Test().show();
	}

	

}