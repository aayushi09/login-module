<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.hibernate.cfg.Configuration"%>
<%@ page import="org.hibernate.service.ServiceRegistry"%>
<%@ page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Transaction"%>
<%@ page import=" java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%int id=Integer.parseInt(request.getParameter("pid"));
	  
Connection con=null;
try { 
	Class.forName("com.mysql.jdbc.Driver");
	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
				"aayushi");
}  catch (Exception e) {
	
	e.printStackTrace();
}
	String sql= "select pimage from Item where pid="+id;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	OutputStream oImage;
	try {
	pstmt = con.prepareStatement(sql);

	rs = pstmt.executeQuery();
	    if(rs.next()) {
	        byte barray[] = rs.getBytes("pimage");
	        response.setContentType("image/jpg");
	        oImage=response.getOutputStream();
	        oImage.write(barray);
	        oImage.flush();
	        oImage.close();
	    }
	}
	catch(Exception ex){
	    ex.printStackTrace();
	}finally {
	    try{
	    if(con!=null)
	       con.close();
	    }catch(Exception ex){
	        ex.printStackTrace();
	    }
	}     	    %>



</body>
</html>