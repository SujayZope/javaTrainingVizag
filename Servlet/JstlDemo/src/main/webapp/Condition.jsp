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

<c:set var="no" value="-5"/>
<c:if test="${no >= 0 }">
<c:out value="Positive Number..."></c:out>
	</c:if>
	<c:if test="${no < 0 }">
	<c:out value="Negative Number..."></c:out>
	</c:if>

</body>
</html>