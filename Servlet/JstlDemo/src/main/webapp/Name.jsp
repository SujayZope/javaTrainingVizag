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
	<form action="Name.jsp" method="get">
		<center>
		Student Name : 
		<input type="text" name="sname"/>
		<input type="submit" value="Show"/>
		
		</center>
	
	</form>
	<c:if test="${param.sname!=null }">
		<c:set var="sname" value="${param.sname }"/>
		Name is :
		<b>
			<c:out value="${sname}"></c:out>
		</b>
	</c:if>
</body>
</html>