package com.java.employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.*;

public class EmployeeMain {
	static EmployeeBAL bal;
	static Scanner sc;
	
	static{
		bal= new EmployeeBAL();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int choice;
		do{
			System.out.println("O P T I O N S");
			System.out.println("------------");
			System.out.println("1. Add Employee  ");
			System.out.println("2. Show Employee  ");
			System.out.println("3. Search Employee  ");
			System.out.println("4. Delete Employee  ");
			System.out.println("5. Update Employee  ");
			System.out.println("6. Write File  ");
			System.out.println("7. Read File  ");
			System.out.println("8. Exit  ");
			System.out.println("Enter your Choice  ");
			choice = sc.nextInt();
			
			switch(choice){
			case 1 :
				try {
					addEmployeeMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2 :
				showEmployeeMain();
				break;
			case 3 :
				searchEmployeeMain();
				break;
			case 4 : 
				deleteEmployeeMain();
			case 5 :
				try {
					updateEmployeeMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			case 6 :
				try {
					writeEmployeeFileMain();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 7 :
				try {
					readEmployeeFileMain();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			case 8 :
				
				return;
			}
		}while(choice!=8);
	}

	
	public static void writeEmployeeFileMain() throws FileNotFoundException,IOException{
		System.out.println(bal.writeEmployeeFileBal());
	}

	
	public static void readEmployeeFileMain() throws ClassNotFoundException,IOException{
		System.out.println(bal.readEmployeeFileBal());
	}
	
	
	public static void showEmployeeMain(){
		
		List<Employee> employeeList = bal.showEmployeeBal();
		
		for(Employee emp : employeeList){
			System.out.println(emp);
		}
	}
	
	public static void searchEmployeeMain(){
		int empno;
		System.out.println("Enter Employee Number  ");
		empno = sc.nextInt();
		Employee employeeFound = bal.searchEmployeeBal(empno);
		if(employeeFound != null){
			System.out.println(employeeFound);
		}else{
			System.out.println("**** Employee Record Not Found ****");
		}
	}
	
	public static void deleteEmployeeMain(){
		int empno;
		System.out.println("Enter Employee Number to delete Employee Details  ");
		empno= sc.nextInt();
		System.out.println(bal.deleteEmployeeBal(empno));
		
	}
	
	
public static void updateEmployeeMain() throws EmployeeException {
		
		Employee emp = new Employee();
		System.out.println("Enter Employe Number  ");
		emp.setEmpno(sc.nextInt());
		System.out.println("Enter Emloyee Name  ");
		emp.setName(sc.next());
		System.out.println("Enter Gender (Male/Female)  ");
		emp.setGender(sc.next());
		System.out.println("Enter Department  ");
		emp.setDept(sc.next());
		System.out.println("Enter Designation  ");
		emp.setDesig(sc.next());
		System.out.println("Enter Basic  ");
		emp.setBasic(sc.nextDouble());
		
		System.out.println(bal.updateEmployeeBal(emp));
		
	}
	
	public static void addEmployeeMain() throws EmployeeException {
		
		Employee emp = new Employee();
		System.out.println("Enter Employe Number  ");
		emp.setEmpno(sc.nextInt());
		System.out.println("Enter Emloyee Name  ");
		emp.setName(sc.next());
		System.out.println("Enter Gender (Male/Female)  ");
		emp.setGender(sc.next());
		System.out.println("Enter Department  ");
		emp.setDept(sc.next());
		System.out.println("Enter Designation  ");
		emp.setDesig(sc.next());
		System.out.println("Enter Basic  ");
		emp.setBasic(sc.nextDouble());
		
		System.out.println(bal.addEmployeeBal(emp));
		
	}
	
	
	

}
