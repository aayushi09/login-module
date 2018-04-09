

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class GetPhotoServlet extends HttpServlet {
	
	
	
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	
    	   int id=Integer.parseInt(request.getParameter("pid"));
   	  
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
    		        byte barray[] = rs.getBytes(1);
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
    		}     	   
    	   
	}

}
