
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


@WebServlet("/InsertServ")
@MultipartConfig
public class InsertServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileInputStream fis = null;
		
		String pname = request.getParameter("pname");
		String psize = request.getParameter("psize");
		int price = Integer.parseInt(request.getParameter("price"));
		String pcolor = request.getParameter("pcolor");
		String plength = request.getParameter("plength");
		String ptype = request.getParameter("ptype");
		String pstatus = request.getParameter("pstatus");
		String description = request.getParameter("description");
		String stock = request.getParameter("stock");
		String suit = request.getParameter("suit");
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		 String strDate=sdf.format(date);
		 String img=request.getParameter("image");
		 FileInputStream fis1=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
					"aayushi");
			File image= new File(img);
			fis1=new FileInputStream(image);
			String query = "insert into product(pname,psize,price,pcolor,plength,ptype,pstatus,description,date,stock,suit,image) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			
          ps.setString(1,pname);
          ps.setString(2,psize );
          ps.setInt(3, price);
          ps.setString(4,pcolor );
          ps.setString(5,plength );
          ps.setString(6,ptype );
          ps.setString(7,pstatus );
          ps.setString(8,description );
          ps.setString(9,strDate );
          ps.setString(10,stock );
          ps.setString(11,suit );
          ps.setBinaryStream(12, (InputStream) fis, (int) (image.length()));
			
  		
           
           
			int row=ps.executeUpdate();
			if(row>0) {
				System.out.println("image inserted");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
