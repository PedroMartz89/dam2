package ejFicheros.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {

    private static final String user = "root";
    private static final String passwd = "toty";
    private static final String url = "jdbc:mysql://localhost/";
    private static String database = "biblioteca";
    private static Connection connection;

    public static Connection getInstance() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url+database, user, passwd);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
