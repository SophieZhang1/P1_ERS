package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        super();
    }

   
    public static ConnectionFactory getInstance() {
        if(instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

   
    public static Connection getConnection() throws SQLException {
        try {
        	Class.forName ("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.println("CLASS WAN'T FOUND");
        	e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=Project1";
        String username = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }
}
