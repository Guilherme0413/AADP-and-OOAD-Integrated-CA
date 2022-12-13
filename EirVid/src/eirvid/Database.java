/*
Algorithms, Architecture and Design Patterns
Object Oriented Analysis and Design
Integrated Continuous Assessment 3
 */
package eirvid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danrlei Martins Student Number: 2020322
 */
public class Database {

    public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection conn = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String dbServer = "jdbc:mysql://localhost:3306/movies_dataset";
            String user = "root";
            String password = "root";

            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password);
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}
