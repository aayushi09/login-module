<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InsertServ" >
			
	Product Name:<input type="text" name="pname" placeholder="Enter Product Name "><br>
	product size:<input type="text" name="psize" placeholder="Enter product size"><br>
	product price:<input type="text" name="price" placeholder="Enter product price"><br>
	product color:<input type="text" name="pcolor" placeholder="Enter product color"><br>
	product length:<input type="text" name="plength" placeholder="Enter product length"><br>
	product type:<input type="text" name="ptype" placeholder="enter type"><br>
	product status:<input type="text" name="pstatus" placeholder="Stitched/Unstitched"><br>
	product description:<input type="text" name="description" placeholder="Enter product description"><br>
	product stock:<input type="text" name="stock" placeholder="Enter availability of product"><br>
	product suitable for:<input type="text" name="suit" placeholder="Ethnic/western"><br>
	image<input type="file" name="image"><br>
	<input  type="submit" value="insert">
	
	
		</form>

</body>
</html>