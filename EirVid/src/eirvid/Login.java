package eirvid;

import eirvid.Interfaces.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import eirvid.Utilities.InputUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Danrlei Martins - Student Number: 2020322
 */
public class Login implements LoginInterface {

    @Override
    public void loginMenu() {

        // Prompt and get user credentials input
        System.out.println("\nWelcome to the Login page");
        System.out.println("\n1. Login");
        System.out.println("\n2. Return to main menu");
        int input = InputUtilities.getUserInt("\nPlease choose an option", 1, 2);

        do {
            switch (input) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    System.out.println("\nReturning...\n");
                    LoginMenu menu = new LoginMenu();
                    menu.displayMenu();
                    return;
            }
        } while (input != 2);

    }

    @Override
    public List<String> userLogin() {

        PreparedStatement ps;
        ResultSet rs;
        String email;
        String password;
        List<String> listOfEmails = new ArrayList<>();
        Map<String, Boolean> userLogins = new HashMap<>();

        //Set static admin credentials
        String adminEmail = "admin@cct.ie";
        String adminPassword = "Adm1nCCT!";

        email = InputUtilities.getUserEmail("\nPlease enter your email");

        password = InputUtilities.getUserPassword("\nPlease enter your password");

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

                System.out.println("\n" + email + " you have successfully logged in!\n");

            } else {
                System.out.println("Wrong username and/or password\n");
            }

            //If statement to determine access control (if user is admin or not)
            if (email.equals(adminEmail) & password.equals(adminPassword)) {

                System.out.println("Welcome Admin\n");
                //Display Admin Menu
            } else {
                System.out.println("Welcome normal user\n");
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }

        listOfEmails.add(email); // add user email to list
        trackUserLogins(listOfEmails); // add emailList to map of user logins
        setUserLoggedIn(userLogins, email); // set user email as logged in

        return listOfEmails;
    }

    // Method to keep track of which user has logged in
    public static Map<String, Boolean> trackUserLogins(List<String> emails) {
        Map<String, Boolean> userLogins = new HashMap<>();

        for (String email : emails) {
            userLogins.put(email, false);
        }
        return userLogins;
    }

    // Set user as logged in
    public static void setUserLoggedIn(Map<String, Boolean> userLogins, String email) {
        userLogins.put(email, true);
    }

    // Check if user is logged in
    public static boolean isUserLoggedIn(Map<String, Boolean> userLogins, String email) {
        return userLogins.get(email);
    }

}
