package ru.gaz_is.dbapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс коннектор для postgres
 */
public class Worker {
    private final String HOST = "jdbc:postgresql://localhost:5432/jsea";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "7753191";
    private Connection connection;

    public Worker() throws SQLException {
        this.connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }
}
