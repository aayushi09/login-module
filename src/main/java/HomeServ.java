
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("sign up")) {
			response.sendRedirect("Register.jsp");

		}

		else if(action.equals("sign in")){
			response.sendRedirect("login.jsp");
		}
		
		}

	}
