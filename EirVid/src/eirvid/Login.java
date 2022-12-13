package eirvid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import eirvid.Utilities.InputUtilities;

/**
 *
 * @author Danrlei Martins Student Number: 2020322
 */
public class Login {

    public static void userLogin() {
        PreparedStatement ps;
        ResultSet rs;
        String email;
        String password;

        //Set static admin credentials
        String adminEmail = "admin@cct.ie";
        String adminPassword = "Adm1nCCT!";

        // Prompt and get user credentials input
        email = InputUtilities.getUserEmail("Please enter your email");

        password = InputUtilities.getUserPassword("Please enter your password");

        // SQL query to authenticate user
        String query = "SELECT * FROM user WHERE email = ? AND password = ? ";

        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            //If statement to match username and password with database
            if (rs.next()) {
                System.out.println("You have successfully logged in");
            } else {
                System.out.println("Wrong username and/or password");
            }

            //If statement to determine access control (if user is admin or not)
            if (email.equals(adminEmail) & password.equals(adminPassword)) {
                System.out.println("Welcome Admin");
                //Display Admin Menu
            } else {
                System.out.println("Welcome normal user");
                // Display User Menu
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }

    }

}
