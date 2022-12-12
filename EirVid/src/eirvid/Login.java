package eirvid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Danrlei Martins
 * Student Number: 2020322
 */
public class Login {

    public static void userLogin() {
        PreparedStatement ps;
        ResultSet rs;
        String email;
        String password;
        Scanner input = new Scanner(System.in);

        //Set static admin credentials
        String adminEmail = "admin@cct.ie";
        String adminPassword = "admin";

        System.out.println("Please enter your email address");
        email = input.next();

        System.out.println("Please enter your password");
        password = input.next();

        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successfull");
            } else {
                System.out.println("Wrong username or password");
            }
            
            //If statement to determine access control (if user is admin or not)
            if (email.equals(adminEmail) & password.equals(adminPassword)){
                //Display Admin Menu
            } else{
                // Display User Menu
            }
        } catch (Exception e) {

        }

    }

}
