package com.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveHistoryDAOImpl implements LeaveHistoryDAO {

	Connection connection;
	PreparedStatement pst;

	public int noOfDaysLeaves(LeaveHistory leaveHistory) {
		int noOfDays;
		long ms = leaveHistory.getEdate().getTime() - leaveHistory.getSdate().getTime();
		System.out.println(ms);
		noOfDays = (int) ((ms) / (1000 * 60 * 60 * 24));
		return ++noOfDays;
	}

	public java.sql.Date convertToSql(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	@Override
	public String applyLeave(LeaveHistory leaveHistory) throws ClassNotFoundException, SQLException {

		int count = Overlaping(leaveHistory);
		if (count == 0) {
			int noOfDays = noOfDaysLeaves(leaveHistory);
			leaveHistory.setNoOfDays(noOfDays);
			leaveHistory.setLeaveType(LeaveType.EL);
			leaveHistory.setLeaveStatus(LeaveStatus.PENDING);
			EmployeeDAO dao = new EmployeeDAOImpl();
			Employee employee = dao.searchEmployeeDao(leaveHistory.getEmpid());
			int leaveAvail = employee.getLeaveAvail();
			int difference = leaveAvail - noOfDays;
			Date today = new Date();
			java.sql.Date sqlToday = new java.sql.Date(today.getTime());
			long check = leaveHistory.getSdate().getTime() - sqlToday.getTime();
			int sdays = (int) (check) / (1000 * 60 * 60 * 24);
			sdays++;
			long check1 = leaveHistory.getEdate().getTime() - sqlToday.getTime();
			int edays = (int) (check1) / (1000 * 60 * 60 * 24);
			edays++;
			if (sdays <= 0) {
				return "Leave-Start Date cannot be Yesterday's Date";
			} else if (edays <= 0) {
				return "Leave-End Date cannot be Yesterday's Date";
			} else if (leaveHistory.getSdate().getTime() > leaveHistory.getEdate().getTime()) {
				return "LeaveStartDate cannot be greater than LeaveEndDate";
			} else if (difference < 0) {
				return "Insufficient Leave Balance...";
			}
			connection = ConnectionHelper.getConnection();
			String cmd = "Insert into leave_history (leave_no_of_days ,"
					+ "emp_id ,leave_start_date ,leave_end_date ,LEAVE_TYPE, leave_status , leave_reason)values(?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(cmd);
			pst.setInt(1, noOfDays);
			pst.setInt(2, leaveHistory.getEmpid());
			pst.setDate(3, leaveHistory.getSdate());
			pst.setDate(4, leaveHistory.getEdate());
			pst.setString(5, leaveHistory.getLeaveType().toString());
			pst.setString(6, leaveHistory.getLeaveStatus().toString());
			pst.setString(7, leaveHistory.getLeaveReason());
			pst.executeUpdate();
			String cmd1 = "Update Employee set EMP_AVAIL_LEAVE_BAL=EMP_AVAIL_LEAVE_BAL-? Where EMP_ID=?";
			pst = connection.prepareStatement(cmd1);
			pst.setInt(1, noOfDays);
			pst.setInt(2, leaveHistory.getEmpid());
			pst.executeUpdate();
			return "Leave Applied Successfully...";
		} else {
			return "Date Overlapped";
		}

	}

	@Override
	public List<LeaveHistory> showLeaveDao(int empid) throws ClassNotFoundException, SQLException {

		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where EMP_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		List<LeaveHistory> leaveList = new ArrayList<LeaveHistory>();
		LeaveHistory leave = null;

		while (rs.next()) {
			leave = new LeaveHistory();
			leave.setLeaveId(rs.getInt("LEAVE_ID"));
			leave.setEmpid(rs.getInt("EMP_ID"));
			leave.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leave.setCommentOfMan(rs.getString("LEAVE_MNGR_COMMENTS"));
			leave.setSdate(rs.getDate("LEAVE_START_DATE"));
			leave.setEdate(rs.getDate("LEAVE_END_DATE"));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leave.setLeaveReason(rs.getString("LEAVE_REASON"));
			leaveList.add(leave);
		}
		connection.close();
		pst.close();
		return leaveList;
	}

	@Override
	public List<LeaveHistory> pendingLeaves(int empId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where emp_id=any(select emp_id from employee where EMP_MANAGER_ID =?) and Leave_status='PENDING'";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		List<LeaveHistory> leaveList = new ArrayList<LeaveHistory>();
		LeaveHistory leaveHistory = null;
		while (rs.next()) {
			leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpid(rs.getInt("EMP_ID"));
			leaveHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setCommentOfMan(rs.getString("LEAVE_MNGR_COMMENTS"));
			leaveHistory.setSdate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setEdate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLeaveReason(rs.getString("LEAVE_REASON"));
			leaveList.add(leaveHistory);
		}
		return leaveList;
	}

	public String approvDeny(int leaveId, int managerId, String status, String mgrComments)
			throws ClassNotFoundException, SQLException {
		LeaveHistory leaveHistory = searchByLeaveId(leaveId);
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println("ENtered");
		System.out.println(leaveId + " " + managerId + " " + status + " " + mgrComments);
		System.out.println(status.toUpperCase());
		if (status.toUpperCase().equals("APPROVED")) {
			String cmd = "update leave_history set LEAVE_STATUS='APPROVED', LEAVE_MNGR_COMMENTS=? WHERE LEAVE_ID=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, mgrComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			return "Leave Approved...";
		} else {
			String cmd = "update leave_history set LEAVE_STATUS='DENIED', LEAVE_MNGR_COMMENTS=? WHERE LEAVE_ID=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, mgrComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL=EMP_AVAIL_LEAVE_BAL+? where EMP_ID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, leaveHistory.getNoOfDays());
			pst.setInt(2, leaveHistory.getEmpid());
			pst.executeUpdate();
			return "Leave Rejected...Balance Updated...";
		}
	}

	public LeaveHistory searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where LEAVE_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveId);
		ResultSet rs = pst.executeQuery();
		LeaveHistory leaveHistory = null;
		if (rs.next()) {
			leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpid(rs.getInt("EMP_ID"));
			leaveHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setCommentOfMan(rs.getString("LEAVE_MNGR_COMMENTS"));
			leaveHistory.setSdate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setEdate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLeaveReason(rs.getString("LEAVE_REASON"));
		}
		return leaveHistory;
	}

	public int Overlaping(LeaveHistory leaveHistory) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String sql = "SELECT COUNT(*) cnt FROM leave_history where EMP_ID =? AND LEAVE_STATUS ='PENDING'"
				+ " AND  LEAVE_START_DATE<=? AND LEAVE_END_DATE >=? ";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, leaveHistory.getEmpid());
		pst.setDate(2, leaveHistory.getSdate());
		pst.setDate(3, leaveHistory.getEdate());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

}
