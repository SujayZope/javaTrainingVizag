package com.infinite.LeaveManagSys;

import java.util.Date;
import java.util.List;

public interface LeaveDAO {
	
	String addLeaveDao(LeaveDetails e);
	List<LeaveDetails> showLeaveDao();
	LeaveDetails searchEmpDao(int empno);
	String deletLeaveDao(int empno);
	String updateLeaveDao(LeaveDetails n);
	
	
	

}