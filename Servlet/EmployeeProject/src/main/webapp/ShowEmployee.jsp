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
	<jsp:useBean id="employDao" class="com.java.emp.EmployeeDaoImpl"/>
	<c:set var ="employList" value="${employDao.showEmployeeDao()}"/>
	<table border="3">
	<tr>
		<th>Employ no</th>
		<th>Employ Name</th>
		<th>Department</th>
		<th>Designation</th>
		<th>Basic</th>
	</tr>
	<c:forEach var="employ" items="${employList}">
	<tr>
		<td>${employ.empno}</td>
		<td>${employ.name}</td>
		<td>${employ.dept}</td>
		<td>${employ.desig}</td>
		<td>${employ.basic}</td>
	</tr>
	</c:forEach>
	</table>
	
	 

</body>
</html>