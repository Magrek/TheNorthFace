package com.vvodianytskyi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverFactory {
    private final static String USER = System.getProperty("db_user");
    private final static String PASSWORD = System.getProperty("db_password");
    private final static String DB = "postgresql";
    private final static String DB_NAME = "thenorthface_db";
    private final static String HOST = "localhost";
    private final static String PORT = "5432";
    private final static String URL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
    private final static String POSTGRESQL_DRIVER = "org.postgresql.Driver";

    public static Connection getConnection() {
        if (USER == null) throw new RuntimeException("Error connecting to the database. Username is null.");
        try {
            Class.forName(POSTGRESQL_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
