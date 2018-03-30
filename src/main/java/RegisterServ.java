

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class RegisterServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String pno= request.getParameter("pno");
		String add= request.getParameter("add");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
					"aayushi");
			String query= "insert into customer(uname,email,pass,fname,phone,address) values('"+ uname +"','"+ email +"','"+ pass +"','"+ name +"','"+ pno +"','"+ add +"')";
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(query);
			
			
			 
			ps.executeUpdate();
			
			HttpSession session = request.getSession();
			session.setAttribute("uname",uname);
			response.sendRedirect("welcome.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	

	}
	}

	


