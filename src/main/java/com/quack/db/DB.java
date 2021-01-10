package com.quack.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paras
 */
public class DB {

	private final static String url = "127.0.0.1";
	private final static String port = "3306";
	private final static String db = "covid19";
	private final static String username = "root";
	private final static String password = "root";

	private static Connection con = null;

	public static Connection getConnection() throws Exception {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		} catch (Exception e) {
			throw new Exception("MySQL Driver error: " + e.getMessage());
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + db + "?serverTimezone=UTC", username, password);

			return con;
		} catch (Exception e) {
			throw new Exception("Could not establish connection with the Database Server: " + e.getMessage());
		}
	}

	public static void close() throws SQLException {

		try {

			// if connection is (still) open
			if (con != null)
				con.close(); // close the connection to the database to end database session

		} catch (SQLException e) {

			throw new SQLException("Could not close connection with the Database Server: " + e.getMessage());
		}

	}// end of close
}
