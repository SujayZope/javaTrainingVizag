<%@page import="com.jsp.jdbc.Employee"%>
<%@page import="com.jsp.jdbc.EmployeeDAO"%>
<%@page import="com.jsp.jdbc.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int empno= Integer.parseInt(request.getParameter("empno"));
	EmployeeDAO dao= new EmployeeDaoImpl();
	Employee employeefound =dao.searchEmployeeDao(empno);
%>
<form action="UpdateEmployee.jsp" method="post">
	Employee No :
	<input type="number" name="empno" value=<%=employeefound.getEmpno() %> readonly="readonly"/> <br><br>
	Employee Name :
	<input type="text" name="ename" value='<%=employeefound.getName() %>' /> <br><br>
	Department :
	<input type="text" name="dept" value=<%=employeefound.getDept() %> /> <br><br>
	Designation :
	<input type="text" name="desig" value=<%=employeefound.getDesig() %> /> <br><br>
	Basic :
	<input type="number" name="basic" value=<%=employeefound.getBasic() %> /> <br><br>
	<input type="submit" value="Update"/>
</form>
<%
	if(request.getParameter("empno")!=null && request.getParameter("basic")!=null){
		Employee employNew = new Employee();
		employNew.setEmpno(Integer.parseInt(request.getParameter("empno")));
		employNew.setName(request.getParameter("ename"));
		employNew.setDept(request.getParameter("dept"));
		employNew.setDesig(request.getParameter("desig"));
		employNew.setBasic(Integer.parseInt(request.getParameter("basic")));
		dao.updateEmployeeDao(employNew);
	
%>
<jsp:forward page="EmployeeShow.jsp"/>
<%
}
%>
</body>
</html>