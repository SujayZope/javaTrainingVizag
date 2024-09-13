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
	<form action="DeleteEmployee.jsp" method="get">
		<center>
			Employee No :
			<input type="number" name="empno"/><br/><br/>
			<input type="submit" value="Delete"/>
		</center>
	</form>
	
	<c:if test="${param.empno!=null }">
	<c:set var="empno" value="${param.empno}"/>
	<jsp:useBean id="beanDao" class="com.java.emp.EmployeeDaoImpl"/>	
	<c:out value="${beanDao.deleteEmployeeDao(empno)}"/><br/><br/>
	
</c:if>
</body>
</html>