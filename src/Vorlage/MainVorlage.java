package Vorlage;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class MainVorlage {

	public static void insert(String Kreditkarte) {

		Connection connection = null;
		Statement stmt = null;
		String jdbcURL = "jdbc:mariadb://localhost:3306/ticketkauf";
		String username = "Moiz";
		String password = "Qasw1029";
		String insertKarteninhaber = "";

		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Successfully connected to database");
			stmt = connection.createStatement();
			stmt.executeUpdate(insertKarteninhaber, 0);
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("inserting Data unsuccessful");
		}
	}
}