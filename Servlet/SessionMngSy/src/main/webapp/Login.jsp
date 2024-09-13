<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		<center>
			User Name :
			<input type="text" name="uname"><br><br>
			Password :
			<input type="password" name="pass"><br><br>
			<input type="submit" name="login"><br><br>
		</center>
	</form>
	<%
		if(request.getParameter("uname")!=null && request.getParameter("pass")!=null){
			String user = request.getParameter("uname");
			String pwd = request.getParameter("pass");
			if(user.equals("Infinite") && pwd.equals("Infinite")){
				//out.println("Correct Credential...");
			%>
			<jsp:forward page="Menu.jsp"/>
			<%
			}else{
				out.println("Invalid Credential...");
			}
		}
	%>
	

</body>
</html>