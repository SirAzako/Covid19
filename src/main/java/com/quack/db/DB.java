package com.quack.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paras
 */
public class DB {
    /** The url of the db. */
    private final static String dburl = "127.0.0.1";

    /** The port of the db. */
    private final static String dbport = "3306";

    /** The db name. */
    private final static String db = "covid19";

    /** The username to access db. */
    private final static String dbusername = "root";

    /** The password of the db. */
    private final static String dbpassword = "root";

    /** The connection variable that holds the connection with the db. */
    private static Connection con = null;

    /**
     * <p>
     *     The method that open the a connection with the db.
     * </p>
     * @return opens the connection and store it to a variable that is
     *         instance of the class Connection.
     * */
    public static Connection getConnection() throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            throw new Exception("MySQL Driver error: " + e.getMessage());
        }

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + dburl + ":"
                            + dbport + "/" + db
                            + "?serverTimezone=UTC",
                    dbusername, dbpassword);

            return con;
        } catch (Exception e) {
            throw new Exception(
                    "Could not establish connection "
                    + "with the Database Server: "
                    + e.getMessage());
        }
    }

    /**
     * <p>
     *    The method that close the connection with the db.
     * </p>
     * */
    public static void close() throws SQLException {

        try {
            // if connection is (still) open
            if (con != null) {
                con.close();
            }
            // close the connection to the database
            // to end database session

        } catch (SQLException e) {

            throw new SQLException(
                    "Could not close connection with "
                    + "the Database Server: "
                            + e.getMessage());
        }

    } // end of close
}
