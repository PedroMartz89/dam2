package DBConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/videoclub";
    private static final String USER = "pedro";
    private static final String PASS = "pedro";

    private static Connection connection = null;

    public DBConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
            }

        } catch (SQLException e) {
            System.out.println("Error en la instancia de la BD");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
