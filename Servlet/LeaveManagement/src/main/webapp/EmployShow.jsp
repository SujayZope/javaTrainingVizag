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
	<jsp:useBean id="employeeDao" class="com.java.lms.EmployeeDAOImpl"></jsp:useBean>
	<c:set var="employeeList" value="${employeeDao.showEmployeeDao()}" />
	<table border="3">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Mail</th>
			<th>Employee Mob No</th>
			<th>Employee Date join</th>
			<th>Department</th>
			<th>Manager ID</th>
			<th>Emoployee Leave Avail Bal</th>
			<th>Show Info</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.empid}</td>
				<td>${employee.ename}</td>
				<td>${employee.email}</td>
				<td>${employee.mobNo }</td>
				<td>${ employee.dateJoin }</td>
				<td>${ employee.dept }</td>
				<td>${employee.managerId  }</td>
				<td>${employee.leaveAvail }</td>
				<td><a
					href="DashBoard.jsp?empId=${employee.empid}&mgrid=${employee.managerId}">INFO</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
