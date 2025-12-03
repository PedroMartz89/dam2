package ra2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://172.16.6.100/";
    private static final String user = "root";
    private static final String passwd = "1234";
    private static final String database = "tv";
    private static Connection connection;

    public static Connection getInstance() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url+database, user, passwd);
                return connection;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
