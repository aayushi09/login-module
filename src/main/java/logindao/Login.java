package logindao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Login {
	// String sql= "select * from login where uname=? and password=?";
	public boolean check(String uname, String pass) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
					"aayushi");
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("select * from customer where uname=? and pass=?");
			statement.setString(1, uname);
			statement.setString(2, pass);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				return true;
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
		

	}
	   String status;
	public String check(String uname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
					"aayushi");
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement("select status from customer where uname=?");
			statement.setString(1, uname);
			ResultSet result = statement.executeQuery();
			result.next() ;
			status= result.getString("status");
			//System.out.println(status);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status ;
	}
}
