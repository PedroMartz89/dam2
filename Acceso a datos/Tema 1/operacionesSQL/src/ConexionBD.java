import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String user = "root";
    private static String passwd = "1234";
    private static String url = "jdbc:mysql://172.16.6.100/";
    private static String dataBase = "ejercicio1";
    private static Connection connection;

    public ConexionBD() {}

    public static Connection getInstance() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url+dataBase, user, passwd);
        }
        return connection;
    }
}
