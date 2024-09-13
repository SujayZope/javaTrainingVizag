<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My JSP Page</title>
</head>
<body>
    <h1>Hello, world!</h1>
    <%-- Your JSP content here --%>
    <% String a =request.getParameter("param1");
    	String b =request.getParameter("param2");
    %>
    <script type="text/javascript">
		name ="<%=a %>";
		data=<%= b %>;
		console.log("name "+name);
		console.log("data "+data);
		
    </script>
</body>
</html>
