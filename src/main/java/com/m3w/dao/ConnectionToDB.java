package com.m3w.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
    protected static Connection connection;
    protected Statement statement;
    public static final String DB_NAME = "src/main/resources/CcMS_M3W.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public void connect() {

        this.statement = null;
        try {
            if (connection == null){
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(CONNECTION_STRING);
            }
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database" + e.getMessage());
        }
    }
}
