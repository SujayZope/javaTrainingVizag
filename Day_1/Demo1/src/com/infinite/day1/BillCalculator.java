package com.infinite.day1;
import java.util.*;

public class BillCalculator {
	
	public void cal(int unit,double billToPay){
		if(unit <= 90){  
            billToPay = unit * 1;  
        }    
        else if(unit <= 150){  
            billToPay = 90 * 1 + (unit - 90) * 1.5;  
        }  
        else if(unit <= 200){  
            billToPay = 90 * 1 + 60 * 1.5 + (unit - 150) * 2;  
        }
        else if(unit <= 240){  
            billToPay = 90 * 1 + 60 * 1.5 + 50 * 2 +(unit - 200) * 2.5;  
        }
        else if(unit > 240){  
            billToPay = 90 * 1 + 60 * 1.5 + 50 * 2 + 40 * 2.5 +(unit - 240) * 3;  
        }
		
        System.out.println("The electricity bill for " +unit+ " is : " + billToPay);   
    }   
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double billToPay = 0;
		System.out.println("Enter Units ");
		int unit = sc.nextInt();
		new BillCalculator().cal(unit, billToPay);

	}

}
