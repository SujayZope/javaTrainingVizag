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
	<form action="SearchEmployee.jsp" method="get">
		<center>
			Employee Id :
			<input type="number" name="empid"/><br/><br/>
			<input type="submit" value="Search"/>
		</center>
	</form>
	
	<c:if test="${param.empid!=null }">
	<c:set var="empno" value="${param.empno}"/>
	<jsp:useBean id="beanDao" class="com.java.emp.EmployeeDaoImpl"/>
	<c:set var="employ" value="${beanDao.searchEmployeeDao(empno)}"/>
	<c:if test="${employ!=null}">
	Employee No :
	<c:out value="${employ.empno}"/><br/><br/>
	Employee Name :
	<c:out value="${employ.name}"/><br/><br/>
	</c:if>
</c:if>
</body>
</html>