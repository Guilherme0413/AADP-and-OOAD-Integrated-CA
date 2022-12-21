package eirvid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to create a Database connection and establish a connection
 * to MySQL. It contains a method called getConnection() which takes
 * ClassNotFoundException, InstantiationException, and IllegalAccessException as
 * parameters. The method first loads the database driver and then creates a
 * connection to the database using the DriverManager.getConnection() method. It
 * then catches any SQLException and prints out the errors. Finally, it returns
 * the Connection object.
 *
 * @author Danrlei Martins - Student Number: 2020322
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
