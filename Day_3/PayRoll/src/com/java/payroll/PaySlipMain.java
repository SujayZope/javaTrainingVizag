package com.java.payroll;

import java.util.List;
import java.util.Scanner;

public class PaySlipMain {

    static EmployeeDao dao;
    static LeaveDao ldao;
    static Scanner sc;

    static {
        dao=new EmployeeDaoImpl();
        sc=new Scanner(System.in);
        ldao=new LeaveDaoImpl();
    }


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----  O P T I O N S  ----");
            System.out.println("-------------------------");
            System.out.println("1. Add Employee");
            System.out.println("2. Leave Details");
            System.out.println("3. Show Payslip");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choie");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addEmployeeMain();
                    break;
                case 2:
                    LeaveMain();
                    break;
                case 3:
                    showPayslipMain();
                    break;
                case 4:
                    return;
            }
        }while (choice != 5) ;
    }




    public static void showPayslipMain(){
        int empno;
        System.out.println("Enter Employ Number...");
        empno=sc.nextInt();
        Employee employFound=dao.searchEmployDao(empno);
        if(employFound!=null){
            System.out.println(employFound);
        }else {
            System.out.println("****** Employ Record Not Found ******");
        }

    }



    public static  void addEmployeeMain(){
        Employee employee=new Employee();
        System.out.println("Enter First Name");
        employee.setFirstName(sc.next());
        System.out.println("Enter Last Name");
        employee.setLastName(sc.next());
        System.out.println("Enter Salary");
        employee.setSalary(sc.nextDouble());
        System.out.println("Enter Leave Availaible");
        employee.setLeaveAvail(sc.nextInt());
        System.out.println(dao.addEmployeeDao(employee));

    }

    public static void LeaveMain(){
        LeaveDetails leave=new LeaveDetails();
        System.out.println("Enter Employee ID");
        leave.setEmpId(sc.nextInt());
        Employee emp=dao.searchEmployDao(leave.getEmpId());
        System.out.println("Enter Leave Taken");
        leave.setLeaveTaken(sc.nextInt());
        System.out.println(ldao.addLeaveDao(leave,emp));
        
    }

}


