<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<jsp:useBean id="leaveDao" class="com.java.lms.LeaveHistoryDAOImpl"></jsp:useBean>
		<jsp:useBean id="leavenew" class="com.java.lms.LeaveHistory" />
		<c:set var="empId" value="${param.empId}" />
		<c:set var="leaveList" value="${leaveDao.pendingLeaves(empId)}" />
		<table border="3">
			<tr>
				<th>Leave ID</th>
				<th>Leave Number of Days</th>
				<th>Leave Manager Comments</th>
				<th>Employee ID</th>
				<th>Leave Start Date</th>
				<th>Leave End Date</th>
				<th>Leave Type</th>
				<th>Leave Status</th>
				<th>Leave Reason</th>
				<th>Select</th>
				<th>Action</th>
			</tr>
			<c:forEach var="leave" items="${leaveList}">
				<tr>
					<td>${leave.leaveId}</td>
					<td>${leave.noOfDays}</td>
					<td>${leave.commentOfMan}</td>
					<td>${leave.empid}</td>
					<td>${ leave.sdate }</td>
					<td>${ leave.edate }</td>
					<td>${leave.leaveType  }</td>
					<td>${leave.leaveStatus }</td>
					<td>${leave.leaveReason }</td>
					<td><a href=AcceptReject.jsp?leaveId=${leave.leaveId}>Accept/Reject</a></td>
					<td><input type="checkbox" id="select" name="approve"
						value="approve"></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<center>
			<input type="submit" value="Approve All">
		</center>
	</form>
</body>
</html>
