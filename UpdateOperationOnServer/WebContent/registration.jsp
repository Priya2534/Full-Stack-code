<%@page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="Registration" method ="post">
<input type = "text" name = "fname" placeholder = "Enter your name">
<input type = "text" name = "birthdate" placeholder = "Enter your birthdate">
<input type = "text" name = "emailid" placeholder = "Enter your emailid">
<input type = "text" name = "mobileno" placeholder = "Enter your mobileno">
<input type ="password" name = "password" placeholder = "Enter password">
<input type = "submit">

</form>

</body>
</html>