package com.infinite.day_2;

public class EmployeeArray {
	public static void main(String[] args) {
		
		
		Employee emp1=new Employee();
		emp1.empno=1031062;
		emp1.name="Yogesh";
		emp1.basic=12334;
		
		Employee emp2=new Employee();
		emp2.empno=1031069;
		emp2.name="Nikhil";
		emp2.basic=999999;
		
		Employee emp3=new Employee();
		emp3.empno=1031045;
		emp3.name="Ritesh";
		emp3.basic=987655;
		
		Employee emp4=new Employee();
		emp4.empno=1031075;
		emp4.name="Deepak";
		emp4.basic=2346987;
		
		Employee[] arrEmp =new Employee[]{emp1,emp2,emp3};
		
		for (Employee employee : arrEmp){
			System.out.println(employee);
		}
		
		
	}

}
