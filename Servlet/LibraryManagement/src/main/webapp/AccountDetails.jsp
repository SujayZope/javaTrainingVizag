<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.TranBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu.jsp"/>
<%
	String user = (String)session.getAttribute("user");
	List<TranBook> booksList = new LibraryDaoImpl().showIssuedBooks(user);
%>
<table border="3">
	<tr>
		<th>Book Id</th>
		<th>User Name</th>
		<th>Issued On</th>
	</tr>
<%
	for(TranBook tbook : booksList) {
%>
	<tr>
		<td><%=tbook.getBookId() %> </td>
		<td><%=tbook.getUserName() %> </td>
		<td><%=tbook.getFromdate() %> </td>
	</tr>
<%
	}
%>
</table>
</body>
</html>