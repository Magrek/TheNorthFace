package com.vvodianytskyi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.vvodianytskyi.data.DataReader.readDataBaseConfig;

public class DriverFactory {
    private final static String USER = readDataBaseConfig("db.user");
    private final static String PASSWORD = readDataBaseConfig("db.password");
    private final static String DB = readDataBaseConfig("db.type");;
    private final static String DB_NAME = readDataBaseConfig("db.name");;
    private final static String HOST = readDataBaseConfig("db.host");;
    private final static String PORT = readDataBaseConfig("db.port");;
    private final static String URL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
    private final static String POSTGRESQL_DRIVER = "org." + DB + ".Driver";

    public static Connection getConnection() {
        if (USER == null)
            throw new RuntimeException("Error connecting to the database. Username is null.");
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
