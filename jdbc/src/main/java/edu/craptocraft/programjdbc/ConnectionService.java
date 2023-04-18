package edu.craptocraft.programjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public static Connection globalConnection;

    public static Connection openDataBaseConnection() throws SQLException {

        System.out.println("Connecting to the database...");
        globalConnection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/biblioteca_JDBC",
                "root", "1234567890");

        System.out.println("Connection valid: " + globalConnection.isValid(5));

        return globalConnection;
        // if (true)
        // throw new RuntimeErrorException(null, "Simulated error!");
    }

    public static void closeDataBaseConnection(Connection connection) throws SQLException {

        System.out.println("Closing database connection");

        connection.close();

        System.out.println("Connection valid: " + connection.isValid(5));
    }

    public static Connection getConnection() {
        return globalConnection;
    }

    public static void setConnection(Connection connection) {
        ConnectionService.globalConnection = connection;
    }
}
