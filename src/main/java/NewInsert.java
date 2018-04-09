
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class NewInsert extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item = new Item();
		item.setName(request.getParameter("pname"));
		item.setPsize(request.getParameter("psize"));
		int p = Integer.parseInt(request.getParameter("price"));
		item.setPrice(p);
		item.setPcolor(request.getParameter("pcolor"));
		item.setPlength(request.getParameter("plength"));
		item.setPtype(request.getParameter("ptype"));
		item.setPstatus(request.getParameter("pstatus"));
		item.setDescription(request.getParameter("description"));
		item.setStock(request.getParameter("stock"));
		item.setSuit(request.getParameter("suit"));
		String myloc=request.getParameter("image");
		Date d = new Date();
		item.setDate(d);
		
		 File file = new File("/home/aayushi/StyleMe/"+myloc);
		 
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
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
	}

}
