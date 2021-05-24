package dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public Connection getConnection() {
		Connection result = null;
		try {
			result = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainbooking", "root", "Welcome123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
}
}
