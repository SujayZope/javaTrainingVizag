<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="ApplyLeave.jsp" method="get">
			Employee Id: <input type="number" name="empid" value="${param.empId}"
				readonly="readonly" /><br /> <br /> Enter Start Date: <input
				type="date" name="sdate" /><br /> <br /> Enter End Date: <input
				type="date" name="edate" /><br /> <br /> Enter Leave Type: <select
				name="leaveType">
				<option value="EL">EL</option>
			</select><br /> <br /> Enter Leave Reason: <input type="text" name="lreason" /><br />
			<br /> <input type="submit" value="Apply Leave" />

		</form>

		<c:if test="${param.lreason!=null}">

			<jsp:useBean id="leaveDao" class="com.java.lms.LeaveHistoryDAOImpl" />
			<jsp:useBean id="leave" class="com.java.lms.LeaveHistory" />
			<c:set var="lstartDate" value="${param.sdate}" />
			<c:set var="lendDate" value="${param.edate}" />
			<c:set var="leaveStartDate"
				value="${leaveDao.convertToSql(lstartDate)}" />
			<c:set var="leaveEndDate" value="${leaveDao.convertToSql(lendDate)}" />
			<jsp:setProperty property="empid" name="leave" value="${param.empid}" />
			<jsp:setProperty property="sdate" name="leave"
				value="${leaveStartDate}" />
			<jsp:setProperty property="edate" name="leave"
				value="${leaveEndDate}" />
			<jsp:setProperty property="leaveType" name="leave"
				value="${param.leaveType}" />
			<jsp:setProperty property="leaveReason" name="leave"
				value="${param.lreason}" />

			<br />
			<c:out value="${leaveDao.applyLeave(leave)}"></c:out>
		</c:if>
	</center>
</body>
</html>

