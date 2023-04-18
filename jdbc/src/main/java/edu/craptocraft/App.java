package edu.craptocraft;

import java.sql.Connection;
import java.sql.SQLException;
import edu.craptocraft.programjdbc.ConnectionService;
import edu.craptocraft.programjdbc.Crud;

public class App {

    public static void main(String[] args) throws SQLException {

        ConnectionService service = new ConnectionService();
        Connection connection = service.openDataBaseConnection();
        Crud crud;
        try {

            crud = new Crud(connection);

            crud.create("El nombre de la rosa", "Seix Barral");
            crud.create("Breve historia del tiempo", "Editorial Planeta");
            crud.create("El que a hierro mata", "Seix Barral");
            crud.read();
            crud.update("El que a hierro mata", "J. A.");
            crud.delete("El que a hierro mata");

        } finally {
            service.closeDataBaseConnection(connection);
        }
    }
}
