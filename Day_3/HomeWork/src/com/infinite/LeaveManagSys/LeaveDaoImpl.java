package com.infinite.LeaveManagSys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveDaoImpl implements LeaveDAO{

	static List<LeaveDetails> employeeList;
	
	static{
		employeeList= new ArrayList<LeaveDetails>();
	}


	@Override
	public List<LeaveDetails> showLeaveDao() {
		// TODO Auto-generated method stub
		return employeeList;
	}



	@Override
	public String addLeaveDao(LeaveDetails e) {
		// TODO Auto-generated method stub
		employeeList.add(e);
		return "Successfully Added";
	}



	@Override
	public LeaveDetails searchEmpDao(int empno) {
		
		LeaveDetails empFound=null;
		
		for (LeaveDetails leaveDetails : employeeList) {
			
			if(leaveDetails.getEmpId()==empno){
				empFound=leaveDetails;
				break;
			}
		}
		return empFound;
	}



	@Override
	public String deletLeaveDao(int empno) {
		
		LeaveDetails empFound=searchEmpDao(empno);
		
		if(empFound!=null){
			employeeList.remove(empFound);
			return "Leave Deleted Succefully";
		}
		return "Record not found";
	}



	@Override
	public String updateLeaveDao(LeaveDetails n) {
		LeaveDetails empFound = searchEmpDao(n.getEmpId());
		if(empFound != null){
			for(LeaveDetails leaveDetails : employeeList){
			   	if(leaveDetails.getEmpId()==n.getEmpId()){
					leaveDetails.setLeaveAppliedOn(n.getLeaveAppliedOn());
					leaveDetails.setLeaveStartDate(n.getLeaveStartDate());
					leaveDetails.setLeaveEndDate(n.getLeaveEndDate());
					leaveDetails.setLeaveReason(n.getLeaveReason());
					leaveDetails.setLeaveType(n.getLeaveType());
					leaveDetails.setNoOfDays(n.getNoOfDays());
					
				}
				break;
			}
			return "Leave Record Updated...";
		}
		return "Leave Record Not Found....";
	}
	

}
