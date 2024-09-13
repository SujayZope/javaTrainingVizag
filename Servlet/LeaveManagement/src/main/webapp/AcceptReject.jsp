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
	<c:set var="eid" value="${empId}" />
	<form action="AcceptReject.jsp">
		<center>
			Leave Id : <input type=number name="leaveId" value="${param.leaveId}" />
			<br /> Employ Id : <input type="number" name="empId" value="${eid}" />
			<br /> Approve or Deny: <select name="status">
				<option value="APPROVED">APPROVED</option>
				<option value="DENIED">DENIED</option>
			</select> <br /> Manager Comments : <input type="text" name="managerComments" />
			<br />
			<Br /> <input type="submit" value="Approve Deny" />
		</center>

	</form>

	<c:if test="${param.leaveId!=null}">
		<jsp:useBean id="leaveDao" class="com.java.lms.LeaveHistoryDAOImpl" />
		<c:set var="leavId" value="${param.leaveId}" />
		<c:set var="eid" value="${param.empId}" />
		<c:set var="stat" value="${param.status}" />
		<c:set var="mgr" value="${param.managerComments}" />
		<br />

		<c:out value="${leaveDao.approvDeny(leavId,eid,stat,mgr)}" />
	</c:if>






</body>
</html>