package com.infinite.abs;

public class AbsTest {
	public static void main(String[] args) {
		Employee[] arr = new Employee[]{
				new HrEmployee(1, "Nikhil", 98765),
				new HrEmployee(2, "Aniket", 98765),
				new HrEmployee(3, "Akshay", 98765),
				new HrEmployee(4, "Mansi", 98765),
				new DeveloperEmp(7, "Yogesh", 546734),
				new DeveloperEmp(8, "Jagruti", 546734),
				new DeveloperEmp(9, "Deepak", 546734),
				new DeveloperEmp(10, "Hitesh", 546734)
		};
		for (Employee employee : arr){
			String type = employee.getClass().getSimpleName();
			
			if(type.equals("DeveloperEmp")){
				System.out.println(employee.showEmployee(employee));
			}
		}
	}

}
