package Ticketkauf;
import java.sql.*;

public class Main {
	static Connection connection = null;
	static Statement stmt = null;
	static Statement stmt1 = null;
	static Statement stmt2 = null;
	static String jdbcURL = "jdbc:mariadb://10.10.240.125:3307/ticketkauf";
	static String username = "Moiz";
	static String password = "Cfeep3en*d";

	static void ConnectionDatabase() throws Exception {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Successfully connected to database");
		} catch (Exception e) {
			System.out.println("Connection to the Database failed");
			System.out.println(e);
		}
	}

	static void insert(int Karte, String KartenInhaber, String Kartennummer, String CVV) {

		String insertKarteninhaber = "INSERT INTO Kredit_Lastschriftkarte(Karte, KarteninhaberIn, Kartennummer, CVV) "
				+ "VALUES('" + Karte + "','" + KartenInhaber + "', '" + Kartennummer + "', '" + CVV + "');";
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(insertKarteninhaber, 0);
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("inserting Data unsuccessful");
		}

	}

	static double[] selectCity(String vonOrtName, String zuOrtName, String ViaOrtName) {

		String selectVonOrtKoordinate = "SELECT koordinatenBreitegrad, koordinatenLaengegrad FROM Orte WHERE Orte = '"
				+ vonOrtName + "'";
		String selectZuOrtKoordinate = "SELECT koordinatenLaengegrad, koordinatenBreitegrad FROM Orte WHERE Orte = '"
				+ zuOrtName + "'";
		String selectViaOrtKoordinate = "SELECT koordinatenLaengegrad, koordinatenBreitegrad FROM Orte WHERE Orte = '"
				+ ViaOrtName + "'";

		try {
			stmt = connection.prepareStatement(selectVonOrtKoordinate);
			stmt1 = connection.prepareStatement(selectZuOrtKoordinate);

			ResultSet VOrt = stmt.executeQuery(selectVonOrtKoordinate);
			ResultSet ZOrt = stmt1.executeQuery(selectZuOrtKoordinate);
			ResultSet viaOrt;

			while (VOrt.next() && ZOrt.next()) {
				double VortLaengegrad = VOrt.getDouble("koordinatenLaengegrad");
				double VortBreitegrad = VOrt.getDouble("koordinatenBreitegrad");
				double ZortLaengegrad = ZOrt.getDouble("koordinatenLaengegrad");
				double ZortBreitegrad = ZOrt.getDouble("koordinatenBreitegrad");
				double ViaortLaengegrad = 0.0;
				double ViaortBreitegrad = 0.0;

				try {
					if (ViaOrtName == "") {
						ViaortLaengegrad = 0.0;
						ViaortBreitegrad = 0.0;
					} else {
						stmt2 = connection.prepareStatement(selectViaOrtKoordinate);

						viaOrt = stmt2.executeQuery(selectViaOrtKoordinate);

						while (viaOrt.next()) {
							ViaortLaengegrad = viaOrt.getDouble("koordinatenLaengegrad");
							ViaortBreitegrad = viaOrt.getDouble("koordinatenBreitegrad");
						}
						System.out.println("Data from Via has been selected");
					}
					System.out.println("Data from Via has been defined");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Data from Via not found/can't be selected");
				}
				return new double[] { VortLaengegrad, VortBreitegrad, ZortLaengegrad, ZortBreitegrad, ViaortLaengegrad,
						ViaortBreitegrad };
			}
			System.out.println("Data selected");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Data not found/can't be selected");
		}
		return null;
	}

	static void delete() throws SQLDataException {
		String deleteInventory = "TRUNCATE Kredit_Lastschriftkarte";
		String resetAutoIncrement = "ALTER TABLE Kredit_Lastschriftkarte AUTO_INCREMENT = 1";

		try {
			stmt = connection.prepareStatement(deleteInventory);
			stmt1 = connection.prepareStatement(resetAutoIncrement);

			ResultSet delete = stmt.executeQuery(deleteInventory);
			ResultSet reset = stmt1.executeQuery(resetAutoIncrement);

			while (delete.next() && reset.next()) {
				System.out.println("deleting and reseting");
			}
			System.out.println("Data deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deleting Data unsuccessful");
		}
	}
}