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
	<form method="post" action="AddEmployee.jsp">
		Employ Name : 
		<input type="text" name="name" /><br/><br/>
		Department : 
		<select name="dept">
			<option value="Java">Java</option>
			<option value="Dotnet">Dotnet</option>
			<option value="Sql">Sql</option>
			<option value="Angular">Angular</option>
		</select> <br/><br/>
		Designation : 
		<select name="desig">
			<option value="Manager">Manager</option>
			<option value="TeamLead">TeamLead</option>
			<option value="Programmer">Programmer</option>
		</select> <br/><br/>
		Basic : 
		<input type="number" name="basic"/> <br/><br/>
		<input type="submit" value="Insert" />
	</form>
	<%
		if (request.getParameter("basic")!=null) {
			EmployeeDAO dao = new EmployeeDaoImpl();
			Employee employ = new Employee();
			employ.setName(request.getParameter("name"));
			employ.setDept(request.getParameter("dept"));
			employ.setDesig(request.getParameter("desig"));
			employ.setBasic(Integer.parseInt(request.getParameter("basic")));
			dao.addEmployeeDao(employ);
	%>
		<jsp:forward page="EmployeeShow.jsp"/>
	<%
		}
	%>
</body>
</html>