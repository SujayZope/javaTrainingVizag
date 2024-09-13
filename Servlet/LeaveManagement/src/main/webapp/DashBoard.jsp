
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<center>

		<jsp:useBean id="employeeDao" class="com.java.lms.EmployeeDAOImpl"></jsp:useBean>

		<c:set var="empId" value="${param.empId}" scope="session" />

		<c:set var="employee" value="${employeeDao.searchEmployeeDao(empId)}" />
		<br />
		<c:out
			value="===========================================================================================" />
		<br/>
		<b><c:out value="Employee Details" /></b> <br/>
		<c:out
			value="===========================================================================================" />
		<br /> Employee ID:
		<c:out value="${employee.empid}" />
		<br /> Employee Name:
		<c:out value="${employee.ename}" />
		<br /> Employee Mail:
		<c:out value="${employee.email} " />
		<br /> Employee Mob No:
		<c:out value="${employee.mobNo }" />
		<br /> Employee Date join:
		<c:out value="${ employee.dateJoin }" />
		<br /> Department:
		<c:out value="${ employee.dept }" />
		<br /> Manager ID:
		<c:out value="${employee.managerId  }" />
		<br /> Emoployee Leave Avail Bal :
		<c:out value="${employee.leaveAvail }" />
		<br /> <br /> <br />

		<c:set var="mgrid" value="${param.mgrid}" />
		<c:set var="manager" value="${employeeDao.searchEmployeeDao(mgrid)}" />
		<c:if test="${manager!=null }">
			<br />
			<c:out
				value="===========================================================================================" />
			<br/>
			<b><c:out value="Manager Details" /></b>
			<br />
			<c:out
				value="===========================================================================================" />
			<br />
Manager ID:
<c:out value="${manager.empid}" />
			<br />
Manager Name:
<c:out value="${manager.ename}" />
			<br />
Manager Mail:
<c:out value="${manager.email} " />
			<br />
Manager Mob No:
<c:out value="${manager.mobNo }" />
			<br />
Manager Date join:
<c:out value="${ manager.dateJoin }" />
			<br />
Department:
<c:out value="${ manager.dept }" />
			<br />
Manager ID:
<c:out value="${manager.managerId  }" />
			<br />
Manager Leave Avail Bal:
<c:out value="${manager.leaveAvail }" />
			<br />
		</c:if>

		<c:if test="${manager==null}">
			<c:out value="Manager Not Found.." />
			<br />
		</c:if>
		<br/>
		<c:out
			value="===========================================================================================" />

		 <br /> <b><c:out value="Apply Leave" /> <br /></b>
		<c:out
			value="===========================================================================================" />
		<br />

		<jsp:include page="ApplyLeave.jsp" /><br />
<br/>
		<c:out
			value="===========================================================================================" />

		<br /> <b><c:out value="Show Leave" /> <br /></b>
		<c:out
			value="===========================================================================================" />
		<br />
		<jsp:include page="ShowLeave.jsp" /><br />
		<c:out
			value="===========================================================================================" />

		<br /> <b><c:out value="Pending Leaves of Employees" /> <br /></b>
		<c:out
			value="===========================================================================================" />
		<br />

		<jsp:include page="PendingLeaves.jsp" />
		<c:out
			value="===========================================================================================" />
	
	</center>
</body>
</html>

