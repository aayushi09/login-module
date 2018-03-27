<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login form</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<div class = "loginBox">
	<img src="user.png" class="user"> </div>
	<form action="login">

		Enter username : <input type="text" name="uname"><br>
		Enter password : <input type="password" name="pass"><br>
		<input type="submit" value="login">



	</form>
</body>
</html>