<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeSearch.jsp" method="get">
		<center>
			Employee No :
			<input type="number" name="empno"/><br/><br/>
			<input type="submit" value="Search"/>
		</center>
	</form>
	<c:if test="${param.empno!=null }">
	<c:set var="empno" value="${param.empno}"/>
	<sql:setDataSource var="conn"
		driver="com.mysql.jdbc.Driver"
  	  	url="jdbc:mysql://localhost:3306/infinite"
    	user="root"
    	password="india@123" />
    	
     <sql:query var="employeeQuery" dataSource="${conn}">
    Select * from Employ where empno=?
    <sql:param value="${empno}"/>
    </sql:query>
    <c:set var="flag" value="0"/>
    <c:forEach var="e" items="${employeeQuery.rows}" >
    Employee No :
    <c:out value="${e.empno}"/><br/><br/>
    Employee Name :
    <c:out value="${e.name}"/><br/><br/>
    Department :
    <c:out value="${e.dept}"/><br/><br/>
    Designation :
    <c:out value="${e.desig}"/><br/><br/>
    Basic :
    <c:out value="${e.basic}"/><br/><br/>
    <c:set var="flag" value="1"/>
    
    </c:forEach>
    <c:if test="${flag==0 }">
    <c:out value="Employee Not Found..."></c:out>
    </c:if>
	</c:if>
</body>
</html>