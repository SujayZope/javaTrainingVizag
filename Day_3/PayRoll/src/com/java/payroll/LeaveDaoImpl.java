package com.java.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaveDaoImpl implements LeaveDao{

    static List<LeaveDetails> leaveList;
    static Scanner sc;
    static  EmployeeDao dao;


    static {
        leaveList = new ArrayList<LeaveDetails>();
        sc=new Scanner(System.in);
        dao=new EmployeeDaoImpl();
    }

    
    public int generateLeaveId(){
        int count=leaveList.size();
        if(count==0){
            return 1;
        }
        int leaveid =leaveList.get(leaveList.size()-1).getLeaveId();
        leaveid++;
        return leaveid;
    }


    @Override
    public List<LeaveDetails> showEmployeeDao() {
        return leaveList;
    }


    public double calculateHome(Employee emp){
    	double loss;
    	double takeHome=0;
    	if(emp.getLeave()!=null){
    		loss=lossofPay(emp);
    		emp.getLeave().setLossOfPay(loss);
    	}else{
    		loss=0;
    	}
    	takeHome=emp.getGross()-emp.getTax()-emp.getPf()-loss;
    	return  takeHome;

    }


    @Override
    public String addLeaveDao(LeaveDetails leave,Employee emp) {
        int leaveid=generateLeaveId();
        leave.setLeaveId(leaveid);
        emp.setLeave(leave);
        leave.setEmpId(emp.getEmpNo());
        refresh(emp);
        leaveList.add(leave);
        return "Leave Details Added Successfully";
    }

    
    public void refresh(Employee emp){
        emp.setTakeHome(calculateHome(emp));
    }

    
    public double lossofPay(Employee employee){
        double loss=0;
        if(employee.getLeave().getLeaveTaken()>employee.getLeaveAvail()) {
            loss = ((employee.getLeave().getLeaveTaken() - employee.getLeaveAvail()) * (employee.getSalary() / (365.25 / 12)));
            employee.setLeaveAvail(0);
            
        }else{
            employee.setLeaveAvail(employee.getLeaveAvail()- employee.getLeave().getLeaveTaken());
        }
        return loss;
     }
 }




