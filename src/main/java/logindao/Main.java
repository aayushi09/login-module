package logindao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Main {
 public static void main(String[] args) {
	 String sql= "select * from login where uname=? and pass=?";
		
			
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ulogin", "root",
					"aayushi");
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
	          statement.setString(1, "abcd");
	          statement.setString(2, "1234");
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				System.out.println(result.getString(1)+ result.getString(2));

			}
	} catch (Exception e) {
		
	}
			
			
			
			
		}
}

