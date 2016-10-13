<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<h4 align="center">Log in to Start</h4>
	<div style="margin-left:auto; margin-right:auto; width: 25%;">
		<form id="form1" name="form1" method="post" action="/ownerapp/login">
			Email:<input type="email" class="form-control" name="email"><br>  
			Password:<input type="password" class="form-control" name="password"><br> 
			<input type="submit" name="Submit" value="Submit" class="btn btn-default"/>
			<c:out value="${loginMessage}"/>
		</form>
	</div>
</body>
</html>
