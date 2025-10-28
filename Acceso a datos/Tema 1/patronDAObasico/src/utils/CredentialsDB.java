package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CredentialsDB {

    private static String url = "jdbc:mysql://localhost/";
    private static String dbName = "empleados_departamentos";
    private static String user = "root";
    private static String passwd = "1234";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(user, passwd, url+dbName);
        }

        return connection;
	}

}
