import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static String host = "jdbc:mysql://172.16.6.100/";
    private static String user = "root";
    private static String passwd = "1234";
    private static String database = "world";
    private static Connection connection;

    public ConnectionDB() {
    }

    public static Connection getInstance() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(host+database, user, passwd);
        }
        return connection;
    }
}
