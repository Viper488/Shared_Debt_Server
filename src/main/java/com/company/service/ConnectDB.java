package com.company.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This interface provides method that allows server to connect with database
 */
public interface ConnectDB {
    /**
     * This method is used to connect with remote database, it returns established connection
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    static Connection connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://195.150.230.210:5434/2020_hamernik_artur",
                        "2020_hamernik_artur", "31996");
        c.setAutoCommit(false);

        return c;
    }
}
