package com.infinite.day_2;

public class EmployCom {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(1,"Yogesh",696969.69);
		Employee emp2 = new Employee(2,"Nikhil",2348898.54);
		Employee emp3 = new Employee(3,"Aniket",956453.87);
		Employee emp4 = new Employee(4,"Deepak",233534.65);
		Employee emp5 = new Employee(5,"Suraj",9345789.45);
		
		Employee[] arrEmp = new Employee[]{emp1,emp2,emp3,emp4,emp5};
		
		for(Employee employ : arrEmp){
			System.out.println(employ);
		}
		
	}

}
