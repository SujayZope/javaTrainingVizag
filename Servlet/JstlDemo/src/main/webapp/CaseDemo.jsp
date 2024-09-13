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
	<form action="CaseDemo.jsp" method="get">
		<center>
			Student No :
			<input type="number" name="sno"/>
			<input type="submit" value="Show"/>
		</center>
	</form>
	<c:if test="${param.sno!=null }">
		<c:set var="sno" value="${param.sno }"/>
		<c:choose>
			<c:when test="${sno==1}">
				<c:out value="Hi I am Nikhil..."></c:out>
			</c:when>
			<c:when test="${sno==2}">
				<c:out value="Hi I am Yogesh..."></c:out>
			</c:when>
			<c:when test="${sno==3}">
				<c:out value="Hi I am Aniket..."></c:out>
			</c:when>
			<c:when test="${sno==4}">
				<c:out value="Hi I am Akshay..."></c:out>
			</c:when>
			<c:when test="${sno==5}">
				<c:out value="Hi I am Mansi..."></c:out>
			</c:when>
			<c:otherwise>
				<c:out value="Invalid Message..."></c:out>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>