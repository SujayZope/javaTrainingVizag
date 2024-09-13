<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Student.jsp" method="get">
		<center>
			Student Name :
			<input type="text" name="sname" />
			Roll No :
			<input type="number" name="rollno" />
			<input type="submit" value="Show" />
		</center>
	</form>
	<%
	if(request.getParameter("sname")!=null){
		String sname = request.getParameter("sname");
	}
	%>
	<jsp:useBean id="beanStudent" class="com.jsp.bean.Student" />
	<jsp:setProperty property="*" name="beanStudent"/>
	Student Name is : 
	<b>
	<jsp:getProperty property="sname" name="beanStudent"/></b><br/>
	Roll No is : 
	<b>
	<jsp:getProperty property="rollno" name="beanStudent"/></b>
</body>
</html>