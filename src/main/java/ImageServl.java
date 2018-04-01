

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
public class ImageServl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String img=request.getParameter("image");
		
		String name =request.getParameter("name");
		FileInputStream fis=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root",
					"aayushi");
			File image= new File(img);
			fis=new FileInputStream(image);
			
			String query = "insert into image(id,image) values(?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			ps.setString(1, name);
			ps.setBinaryStream(2, (InputStream) fis, (int) (image.length()));
			
		int row=ps.executeUpdate();
		if(row>0) {
			System.out.println("image inserted");
		}
		con.close();
		//obj.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(name);
		}
		finally {
			System.out.println(name);
		}
	}

	}



