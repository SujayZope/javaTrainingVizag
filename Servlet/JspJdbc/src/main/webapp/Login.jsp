<%@page import="java.sql.SQLException"%>
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
	<form method="post"  action="Login.jsp">
<center>
		User Name:
		<input type="text" name="user"><br><br>
		
		Password:
		<input type="password" name="pwd"><br><br>
		<input type="submit" value="Login"/>
</center>

</form>
<%
String username = request.getParameter("user");
String password = request.getParameter("pwd");
EmployeeDAO dao = new EmployeeDaoImpl();

int count=dao.authenticate(username,password);

	if (count==1){
%>
<jsp:forward page="EmployeeShow.jsp"></jsp:forward>		

<%		
	}
%>
</body>
</html>