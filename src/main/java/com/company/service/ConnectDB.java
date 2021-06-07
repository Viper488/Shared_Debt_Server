package com.company.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface ConnectDB {
    static Connection connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://195.150.230.210:5434/2020_hamernik_artur",
                        "2020_hamernik_artur", "31996");
        c.setAutoCommit(false);

        return c;
    }
}
