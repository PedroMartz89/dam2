package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost/";
    private static final String user = "root";
    private static final String passwd = "toty";
    private static final String database = "instituto";
    private static Connection connection;

    public static Connection getInstance() {
        try {
            if (connection.isClosed() || connection == null) {
                connection = DriverManager.getConnection(url+database, user, passwd);
                return connection;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
