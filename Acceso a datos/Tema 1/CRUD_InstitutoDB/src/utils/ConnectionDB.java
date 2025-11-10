package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String user = "root";
    private static String passwd = "toty";
    private static String database = "instituto";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url+database, user, passwd);
            return connection;
        }
        return connection;
    }

    private void closeConnection() {
        connection = null;
    }
}
