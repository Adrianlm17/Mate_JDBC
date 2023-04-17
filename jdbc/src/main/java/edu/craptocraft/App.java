package edu.craptocraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        try {
            openDataBaseConnection();
            createData("Breve historia del tiempo", "Editorial Planeta");
            createData("El que a hierro mata", "Seix Barral");
            readData();
            updateData("El que a hierro mata", "J. A.");
            deleteData("Breve historia del tiempo");

        } finally {
            closeDataBaseConnection();
        }
    }

    // ----------- crud operations ----------

    private static void deleteData(String titulo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM libros " +
                        "WHERE titulo LIKE ?")) {
            statement.setString(1, titulo);
            int rowSelected = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowSelected);
        }
    }

    private static void updateData(String titulo, String autor) throws SQLException {
        System.out.println("Updating data...");
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE libros " +
                        "SET autor = ? " +
                        "WHERE titulo = ?")) {
            statement.setString(1, autor);
            statement.setString(2, titulo);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }

    }

    private static void readData() throws SQLException {
        System.out.println("Reading data...");
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT titulo, autor " +
                        "FROM libros")) {
            ResultSet resultset = statement.executeQuery();
            boolean empty = true;
            while (resultset.next()) {
                String titulo = resultset.getString(1);
                String autor = resultset.getString(2);
                System.out.println("\t>" + titulo + ":" + autor);
                empty = false;
            }
            if (empty) {
                System.out.println("\t");
            }
        }
    }

    private static void createData(String titulo, String autor) throws SQLException {
        System.out.println("Connecting to the database...");
        int rowsInserted;
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO libros(titulo, autor)" +
                        "VALUES (?, ?)")) {
            statement.setString(1, titulo);
            statement.setString(2, autor);
            rowsInserted = statement.executeUpdate();
        }
        System.out.println("Rows inserted: " + rowsInserted);
    }

    public static void openDataBaseConnection() throws SQLException {

        System.out.println("Connecting to the database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/biblioteca_JDBC",
                "root", "1234567890");

        System.out.println("Connection valid: " + connection.isValid(5));

        // if (true)
        // throw new RuntimeErrorException(null, "Simulated error!");
    }

    public static void closeDataBaseConnection() throws SQLException {

        System.out.println("Closing database connection");

        connection.close();

        System.out.println("Connection valid: " + connection.isValid(5));
    }
}
