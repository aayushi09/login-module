<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContent.request.contextPath }/js/jquery-1.10.2.js "></script>
<script type="text/javascript">
  ${document}.ready(function(){
      $('#checkBoxAll').click(function(){
         if($1(this).is(":checked"))
             $('.chkCheckBoxId').prop('checked',true);
         else
        	 $('.chkCheckBoxId').prop('checked',false);
          });

	  });


</script>
</head>
<body>
<form action="">

 <input type="submit" value="delete"onclick="return confirm('Are you sure ??')"/>
 <br>
 ${error} 
 <br>
 <table cellpadding="2" cellspacing="2" border="1">
 <tr>
    <th><input type="checkbox" id="checkBoxAll">
    </th>
    <th>Name</th>
 <th>size</th>
  <th>price</th>
   <th>color</th>
    <th>length</th>
     <th>type</th>
      <th>status</th>
      
       <th>description</th>
        <th>date</th>
         <th>Stock</th>
          <th>Suitable for</th>
          
</tr>
c:forEach var="" items="${listAccount}"
<tr>
  <td><input type="checkbox" class="chkCheckBoxId" value="$">


</form>

</body>
</html>