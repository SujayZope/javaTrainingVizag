package com.infinite.day1;

public class CurrentBill {
	
	public void cal(int unit,double billToPay){
		double rate;
		if(unit <= 90){
			rate =1;
			billToPay=unit*rate;
			rate = 1.5;
		}
			if(unit >=90){
				rate=1;
				billToPay=(90*rate);
				rate=1.5;
				if(unit - 150 >= 0){
					billToPay +=(rate*60);
				}
				else{
					billToPay += (rate * (unit-90));
				}
			}
			
			if(unit > 150){
				rate = 2;
				if(unit - 200 > 0){
					billToPay += (rate * 50);
				}
				else{
					billToPay += (rate *(unit-150));
				}
			}
			if(unit > 200){
				rate = 2.5;
				if(unit - 240 > 0){
					billToPay += (rate * 40);
				}
				else{
					billToPay += (rate *(unit-200));
				}
			}
			if(unit > 240){
				rate = 3;
				if(unit - 240 > 0){
					billToPay += (rate * 50);
				}
				else{
					billToPay += (rate *(unit-150));
				}
			}
		
        System.out.println("The electricity bill for " +unit+ " is : " + billToPay);   
    }   
		
	
	public static void main(String[] args) {
		double billToPay = 0;
		int unit =91;
		new BillCalculator().cal(unit, billToPay);

	}

}
