

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



@WebServlet
public class InsertServlett extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			  
				Item item = new Item();
				item.setDate();
				item.setDescription(request.getParameter("description"));
				item.setName(request.getParameter("pname"));
				item.setPcolor(request.getParameter("pcolor"));
				item.setPlength(request.getParameter("plength"));
				item.setPrice(Integer.parseInt(request.getParameter("price")));
				item.setPsize(request.getParameter("psize"));
				item.setPstatus(request.getParameter("pstatus"));
				item.setPtype(request.getParameter("ptype"));
				item.setStock(request.getParameter("stock"));
				item.setSuit(request.getParameter("suit"));
				String myloc=request.getParameter("image");
			  File file = new File(myloc);
		        byte[] bFile = new byte[(int) file.length()];
		 
		        try {
		            FileInputStream fileInputStream = new FileInputStream(file);
		            fileInputStream.read(bFile);
		            fileInputStream.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        item.setPimage(bFile);
			  
	        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Item.class);
	        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	        SessionFactory sf = con.buildSessionFactory(reg);
	        Session session = sf.openSession();
	        Transaction tx =session.beginTransaction();
	        session.save(item);
	        tx.commit();
	}

}
