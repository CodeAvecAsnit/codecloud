package com.labwork.jspjava.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnector {
    private static final String DB_URL;
    private static final String DB_USERNAME;
    private static final String DB_PASSWORD;

    static {
        DB_URL = "jdbc:mysql://localhost:3306/servletdb?allowMultipleQueries=true";
        DB_USERNAME = "root";
        DB_PASSWORD = "asnit123";
    }

    public static Connection getDBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Some unexpected error occurred", ex);
        }
    }
}
