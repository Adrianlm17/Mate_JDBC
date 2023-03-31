package edu.craptocraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class App {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        try {

            openDataBaseConnection();

        } finally {
            closeDataBaseConnection();
        }

    }

    public static void openDataBaseConnection() throws SQLException {
        System.out.println("Connecting to the database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/biblioteca_JDBC",
                "root", "1234567890");
        System.out.println("Connection valid: " + connection.isValid(5));
        if (true)
            throw new RuntimeErrorException(null, "Simulated error!");
    }

    public static void closeDataBaseConnection() throws SQLException {
        System.out.println("Closing database connection");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
    }
}
