

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logindao.Login;


@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("uname");
		String password= request.getParameter("pass");
		Login lg =new Login();
		if(lg.check(username,password )== true)
		{  
			if(lg.check(username).equals("user")) {
			HttpSession session = request.getSession();
			session.setAttribute("uname",username);
			response.sendRedirect("welcome.jsp");
			}
			else if(lg.check(username).equals("admin")) {
				response.sendRedirect("Admin.jsp");
			}
			else 
				response.sendRedirect("login.jsp");
		}
	else {
			response.sendRedirect("login.jsp");
		}
		
	}

	
}

