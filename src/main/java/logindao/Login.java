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
					.prepareStatement("select * from login where uname=? and password=?");
			statement.setString(1, uname);
			statement.setString(2, pass);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}
