/*
Algorithms, Architecture and Design Patterns
Object Oriented Analysis and Design
Integrated Continuous Assessment 3
 */
package eirvid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Danrlei Martins
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
            String query = "SELECT * FROM movies";

            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Outcome is: Successfull");

            // Loop through the result set
            System.out.println("ID" + "\t" + "First Name" + "\t\t" + "Last Name");
            System.out.println("===============================================");
            while (rs.next()) {
                System.out.println(rs.getString("movie_id") + "\t" + rs.getString("movie_title")
                        + "\t\t\t" + rs.getString("genre"));
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
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
