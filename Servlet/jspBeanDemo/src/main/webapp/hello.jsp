
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanHelloWorld" class="com.jsp.bean.HelloWorld"/>
Default message is :
<b>
<jsp:getProperty property="greeting" name="beanHelloWorld"/></b>
<jsp:setProperty property="greeting" name="beanHelloWorld" value="Good Afternoon..."/><br/><hr/>
Updated Message is :
<b>
<jsp:getProperty property="greeting" name="beanHelloWorld"/>
</b>
</body>
</html>