package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    /**
     * Implement Database Connection
     */
    Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdetails", "postgres",
                    "root");
        } catch (SQLException e) {
            System.out.println("Connection Error");
        }
        return connection;
    }
}
