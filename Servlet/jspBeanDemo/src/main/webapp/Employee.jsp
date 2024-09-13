<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Employee.jsp" method="get">
		<center>
			Employee No   :   
			<input type="number" name="empno" /><br/><br/>
			Employee Name :  
			<input type="text" name="name" /><br/><br/>
			Department    :
			<input type="text" name="dept" /><br/><br/>
			Designation   :
			<input type="text" name="desig" /><br/><br/>
			Basic         :
			<input type="number" name="basic" /><br/><br/>
			<input type="submit" value="Show" /><br/><br/>
		</center>
	</form>
	
	<jsp:useBean id="beanEmployee" class="com.jsp.bean.Employee" />
	<jsp:setProperty property="*" name="beanEmployee"/>
	Employee No : 
	<b><jsp:getProperty property="empno" name="beanEmployee"/></b><br/><br/>
	Employee Name : 
	<b><jsp:getProperty property="name" name="beanEmployee"/></b><br/><br/>
	Department : 
	<b><jsp:getProperty property="dept" name="beanEmployee"/></b><br/><br/>
	Designation : 
	<b><jsp:getProperty property="desig" name="beanEmployee"/></b><br/><br/>
	Basic : : 
	<b><jsp:getProperty property="basic" name="beanEmployee"/></b><br/><br/>
	

</body>
</html>