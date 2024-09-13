package com.java.lms;

import java.sql.SQLException;
import java.util.List;

public interface LeaveHistoryDAO {

	String applyLeave(LeaveHistory leaveHistory) throws ClassNotFoundException, SQLException;

	List<LeaveHistory> pendingLeaves(int empId) throws ClassNotFoundException, SQLException;

	List<LeaveHistory> showLeaveDao(int empid) throws ClassNotFoundException, SQLException;

	String approvDeny(int leaveId, int managerId, String status, String mgrComments) throws ClassNotFoundException, SQLException;

	LeaveHistory searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException;

}
