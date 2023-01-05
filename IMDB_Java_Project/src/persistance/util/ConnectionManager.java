package persistance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Using this class to connect java to SQL database

public class ConnectionManager {
    private final String DB_USER = "root"; // my SQL username
    private final String DB_USER_PWD = "666Bruce666"; // my SQL password
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/pokedex";

    static Connection connection = null;

    // try & catch-->means: when we launch the app, we can go through errors:
    // you will find them at line 29-30; "catch them" if they occour and do not
    // crash the whole system.

    public ConnectionManager() {
        try {
            Class.forName(DB_DRIVER); // Try to load the driver
            System.out.println("Driver successfully loaded ");

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PWD);
            System.out.println("Connection to Database: OK!");

        } catch (SQLException | ClassNotFoundException error) {
            System.err.println(error.getCause());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
