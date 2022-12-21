package eirvid;

import eirvid.Interfaces.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import eirvid.Utilities.InputUtilities;

/**
 *
 * @author Danrlei Martins - Student Number: 2020322
 */
public class Login implements LoginInterface {

    PreparedStatement ps;
    ResultSet rs;
    private String email;
    private String password;
    private String adminEmail;
    private String adminPassword;
    private String query;
    private String firstName;
    private String lastName;
    LoginMenu menu = new LoginMenu();

    @Override
    public void userLogin() {

        //Set static admin credentials
        adminEmail = "admin@cct.ie";
        adminPassword = "Adm1nCCT!";

        // Prompt and get user credentials input
        email = InputUtilities.getUserEmail("\nPlease enter your email");

        password = InputUtilities.getUserPassword("\nPlease enter your password");

        // SQL query to authenticate user
        query = "SELECT first_name, last_name, email, password FROM user WHERE email = ? AND password = ? ";

        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            //If statement to match username and password with database
            if (rs.next()) {

                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");

                Customer renter = new Customer(firstName, lastName, email);
                System.out.println("\nWelcome " + firstName + " " + lastName);

            } else {
                System.out.println("\nWrong username and/or password\n");
                System.out.println("\nReturning to login menu...");
                menu.displayMenu();
            }

            //If statement to determine access control (if user is admin or not)
            if (email.equals(adminEmail) & password.equals(adminPassword)) {

                System.out.println("Welcome Admin\n");
                //Display Admin Menu - To be implemented
            } else {
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }

    }

}
