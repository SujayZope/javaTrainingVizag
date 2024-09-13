<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddEmployee.jsp" method="get">
		<center>
			Employee Name :
			<input type="text" name="name"/><br/><br/>
			Department :
			<input type="text" name="dept"/><br/><br/>
			Designation :
			<input type="text" name="desig"/><br/><br/>
			Basic :
			<input type="number" name="basic"/><br/><br/>
			<input type="submit" value="insert"/>
		</center>
	</form>
	<c:if test="${param.basic!=null }">
	<jsp:useBean id="employDao" class="com.java.emp.EmployeeDaoImpl"/>
	<jsp:useBean id="employ" class="com.java.emp.Employee"/>
    <jsp:setProperty property="*" name="employ"/>	
    <c:out value="${employDao.addEmployeeDao(employ) }"></c:out>
    
    </c:if>
</body>
</html>