package edu.craptocraft.programjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    private static Connection connection;

    public Crud(Connection connection) {
        this.connection = connection;
    }

    public static void delete(String titulo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM libros " +
                        "WHERE titulo LIKE ?")) {
            statement.setString(1, titulo);
            int rowSelected = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowSelected);
        }
    }

    public static void update(String titulo, String autor) throws SQLException {
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

    public static void read() throws SQLException {
        System.out.println("Reading data...");
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT titulo, autor " +
                        "FROM libros")) {
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                String titulo = resultset.getString(1);
                String autor = resultset.getString(2);
                System.out.println("\t>" + titulo + ":" + autor);
            }

        }
    }

    public static void create(String titulo, String autor) throws SQLException {
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

}