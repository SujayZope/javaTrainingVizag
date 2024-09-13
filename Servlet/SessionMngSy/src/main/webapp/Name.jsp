<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Name.jsp" method="get">
		First Name :
		<input type="text" name="fname"><br><br>
		Last Name : 
		<input type="text" name="lname"><br><br>
		<input type="submit" value="Show">
</form>

	<%
		if(request.getParameter("fname")!=null && request.getParameter("lname")!=null){
			String fullName = request.getParameter("fname") +
					" " +request.getParameter("lname");
			out.println("Full Name is  : " +fullName);
		}
	%>

</body>
</html>