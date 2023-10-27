<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.banana.models.LoginBean"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged!!</title>
</head>
<body>

	<p>You are successfully logged in!</p>
	<%  
	LoginBean bean=(LoginBean)request.getAttribute("bean");  
	out.print("Welcome, "+bean.getName());  
	%>
</body>
</html>