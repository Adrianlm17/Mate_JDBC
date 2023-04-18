package edu.craptocraft.programjdbc;

import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionServicePool {

    private static HikariDataSource dataSource;

    public static HikariDataSource initDataBaseConnectionPool() throws SQLException {

        dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/biblioteca_JDBC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234567890");

        return dataSource;

    }

    public static void closeDataBaseConnectionPool(HikariDataSource connection) throws SQLException {
        connection.close();
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }

    public static void setConnection(HikariDataSource connection) {
        dataSource = connection;
    }
}
