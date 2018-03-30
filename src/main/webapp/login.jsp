<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login form</title>
<link rel="stylesheet" href="css/login.css" / >
</head>
<body><div class="title">
<h1 >StyleMe</h1></div>
	<div class="loginBox">

		<img src="images/user.png" style="opacity:0.6;" class="user"> <br>
		
		<p>
		<h2 align="center">Sign In</h2>
		</p>
		<hr>
		<form action="login">
			
			<h3><font color=#FFE633><p>Username : <input type="text"
				name="uname" placeholder="Enter Username"></p>
				<p>Password : <input type="password" name="pass"
				placeholder="******"></p></h3>
				<a href="http://localhost:8080/login-module-new/Register.jsp" style="color: #fff">Create new account</a>
			<h6 align="center">
					<input  type="submit" value="login"background-color="#FFE633">
				</h6> </font>
    
<hr>
		</form>
	</div>
</body>
</html>