<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Calculation.jsp" method="get">
		<center>
			First Number  :   
			<input type="number" name="firstno" /><br/><br/>
			Second Number :  
			<input type="number" name="secondno" /><br/><br/>
			<input type="submit" value="Show" /><br/><br/>
		</center>
	</form>
	
	<jsp:useBean id="beanCalc" class="com.jsp.bean.Calculation" />
	<jsp:setProperty property="*" name="beanCalc"/>
	Sum is : 
	<b><%=beanCalc.sum() %></b><br/><br/>
	Sub is : 
	<b><%=beanCalc.sub() %></b><br/><br/>
	Multi is : 
	<b><%=beanCalc.multi() %></b><br/><br/>
	
	

</body>
</html>