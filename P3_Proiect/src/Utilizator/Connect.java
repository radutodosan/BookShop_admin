package Utilizator;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection connection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_p3", "root", "");
		}
		catch(Exception except) {
			except.printStackTrace();
		}
		
		return con;
	}
}
