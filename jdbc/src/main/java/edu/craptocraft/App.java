package edu.craptocraft;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import edu.craptocraft.programjdbc.ConnectionService;
import edu.craptocraft.programjdbc.ConnectionServicePool;
import edu.craptocraft.programjdbc.Crud;
import edu.craptocraft.programjdbc.CrudPool;

public class App {

    /**
     * @param args
     * @throws SQLException
     */
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

        ConnectionServicePool servicePool = new ConnectionServicePool();
        HikariDataSource connectPoll = servicePool.initDataBaseConnectionPool();
        CrudPool crudPool;
        try {

            crudPool = new CrudPool(connectPoll);

            crudPool.create("El nombre de la rosa", "Seix Barral");
            crudPool.create("Breve historia del tiempo", "Editorial Planeta");
            crudPool.create("El que a hierro mata", "Seix Barral");
            crudPool.read();
            crudPool.update("El que a hierro mata", "J. A.");
            crudPool.delete("El que a hierro mata");

        } finally {
            service.closeDataBaseConnection(connection);
        }

    }
}
