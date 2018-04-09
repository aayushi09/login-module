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



<html>
<body>

<%
	  
Connection con=null;
try { 
	Class.forName("com.mysql.jdbc.Driver");
	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
				"aayushi");
}  catch (Exception e) {
	
	e.printStackTrace();
}
	String sql= "select pid,pname from Item";
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	OutputStream oImage;
	try {
	pstmt = con.prepareStatement(sql);

	rs = pstmt.executeQuery();
	    while(rs.next()) {
	        String name=rs.getString("pname");
	        int id = rs.getInt("pid");
	        %>
	        <a href="http://localhost:8080/login-module-new/ItemDetail.jsp?pid=<%=id %>">
<img src="DispiImg.jsp?pid=<%=id %>"width=400 height=400></a>
<h3><%=name %></h3>
	   <%    
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
