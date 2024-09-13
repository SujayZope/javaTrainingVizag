package com.infinite.LeaveManagSys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class LeaveMain {
	
	static LeaveBAL bal;
	static Scanner sc;
	
	
	static{
		sc = new Scanner(System.in);
		bal=new LeaveBAL();
	}
	
	
	public static void addLeaveMain() throws ParseException, EmployeeException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		LeaveDetails e=new LeaveDetails();
		
		System.out.println("Enter Employee No ");
		e.setEmpId(sc.nextInt());
		
		System.out.println("Enter leave start date");
		String date=sc.next();
		e.setLeaveStartDate(sdf.parse(date));
		
		System.out.println("Enter leave end date");
		String date2=sc.next();
		e.setLeaveEndDate(sdf.parse(date2));
		
		System.out.println("Enter leave type PL/ML/EL");
		e.setLeaveType(LeaveType.valueOf(sc.next()));
		
		System.out.println("Enter leave reason");
		e.setLeaveReason(sc.next());
		
		System.out.println(bal.addLeaveBal(e));
	
	}
	
	
	public static void showEmployeeMain(){
		
		List<LeaveDetails> employList=bal.showLeaveBal();
		
		for (LeaveDetails employ : employList) {
			System.out.println(employ);
		}
	}
	
	
	public static void searchEmpMain(){
		int empno;
		
		System.out.println("Enter Employee No  ");
		empno=sc.nextInt();
		
		LeaveDetails empFound=bal.searchEmpBal(empno);
		if(empFound!=null){
			System.out.println(empFound);
		}else{
			System.out.println("Employee Record not found");
		}
	}
	
	public static void deletLeaveMain(){
		int empno;
		System.out.println("Enter Employee No ");
		empno=sc.nextInt();
		
		System.out.println(bal.deletLeaveBal(empno));
	}
	
	public static void updateLeaveMain() throws ParseException, EmployeeException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		LeaveDetails e=new LeaveDetails();
		
		System.out.println("Enter Employee No");
		e.setEmpId(sc.nextInt());
		
		System.out.println("Enter leave start date");
		String date=sc.next();
		e.setLeaveStartDate(sdf.parse(date));
		
		System.out.println("Enter leave end date");
		String date2=sc.next();
		e.setLeaveEndDate(sdf.parse(date2));
		
		System.out.println("Enter leave type PL/ML/EL");
		e.setLeaveType(LeaveType.valueOf(sc.next()));
		
		System.out.println("Enter Leave Reason");
		e.setLeaveReason(sc.next());
		
		System.out.println(bal.updateLeaveBal(e));
	
	}
	
	public static void main(String[] args) {
		int choice;
		do{
			System.out.println("-----  O P T I O N S  ------");
			System.out.println(("......................."));
			System.out.println("1. Add Leave");
			System.out.println("2. Show Leave");
			System.out.println("3. Search Leaves for empolyee");
			System.out.println("4. Delete Leave Details");
			System.out.println("5. Update Leave Details");
			System.out.println("6.EXIT");
			System.out.println("Enter your choice...");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				try {
					addLeaveMain();
				} catch (ParseException e ) {
					e.printStackTrace();
				}catch(EmployeeException e){
					System.out.println(e.getMessage());
				}
					break;	
			case 2:
					showEmployeeMain();
					break;	
			case 3:
					searchEmpMain();
					break;
			case 4:
					deletLeaveMain();
					break;
			case 5:
				try {
					updateLeaveMain();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 6:
					return;
			default:
				break;
			}
		}while(choice!=6);			
	}	
}
