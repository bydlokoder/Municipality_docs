package com.company.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String CONNECTION_URL = "jdbc:mysql://46.101.155.168:3306/municipality";
    private static final String USERNAME = "mun_kum";
    private static final String PASSWORD = "ZCZog9uI4H";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            initialize();
        }
        return connection;
    }

    private static void initialize() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
    }
}
