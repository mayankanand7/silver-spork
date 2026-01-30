package com.task.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/task-manager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";


    // Constructor
    // ------------------------------------------------------------------------

    private DBUtil() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
