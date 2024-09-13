<%@page import="com.jsp.jdbc.Employee"%>
<%@page import="com.jsp.jdbc.EmployeeDaoImpl"%>
<%@page import="com.jsp.jdbc.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int empno= Integer.parseInt(request.getParameter("empno"));
	EmployeeDAO dao= new EmployeeDaoImpl();
	dao.deleteEmployeeDao(empno);
%>
<jsp:forward page="EmployeeShow.jsp"/>


</body>
</html>