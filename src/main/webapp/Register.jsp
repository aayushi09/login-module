<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Register.css" / >
<script type="text/javascript">
	function validateform() {
		var name = document.myform.name.value;
		var password = document.myform.pass.value;
		var number = document.myform.pno.value;
		var x=document.myform.email.value;  
		var atposition=x.indexOf("@");  
		var dotposition=x.lastIndexOf(".");
		var uname = document.myform.uname.value;
		var address = document.myform.add.value;
		if (name == null || name == "") {
			alert("Name can't be blank");

		}
		if (uname == null || uname == "") {
			alert(" userName can't be blank");

		}
		if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
			  alert("Please enter a valid e-mail address ");  

		if (number.length != 10 || isNaN(number)) {
			alert("must enter valid phone number")
		}
		if (address == null || address == "") {
			alert("address can't be blank");
		}
		
		if (password.length < 6 ) {
			alert("Password must be at least 6 characters long.");
		}
	    
			return false;
		}
	}
</script>
</head>
<body> 
<p>
		<div class="title"><h2 align="center"> Register Here</h2></div>
		</p>
   <div class="RegisterBox" >
	<form name="myform" action="RegisterServ"
		onsubmit="return validateform()">
		

		  Enter Name : <input type="text" name="name" placeholder="Enter full name"><br>
		  Enter username : <input type="text" name="uname" placeholder="enter username"><br>
		  Enter email : <input type="text" name="email" placeholder="contact@example.com"><br> 
		  Enter phone number : <input type="text" name="pno" placeholder="+91**********"><br> 
		  Enter address: <input type="text" name="add" placeholder="street no.,colony,city"><br> 
		  Enter password : <input type="password" name="pass" placeholder="******"><br> <input type="submit"
			value="sign up">



	</form>
	</div>
</body>
</html>