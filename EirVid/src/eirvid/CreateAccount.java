package eirvid;

/**
 *
 * @author Danrlei Martins & Guilherme Oliveira 
 * Student Numbers: 2020322 & 2020316
 */
import eirvid.Interfaces.UserRegistrationInterface;
import eirvid.Utilities.InputUtilities;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount implements UserRegistrationInterface {

    @Override
    public void userRegister() {
        String firstName;
        String lastName;
        String email;
        String password;
        PreparedStatement ps;

        System.out.println("Welcome to the user registration process \n");
        firstName = InputUtilities.getUserText("Please enter your first name\n");
        lastName = InputUtilities.getUserText("Please enter your last name\n");
        email = InputUtilities.getUserEmail("Please enter a valid email address\n");
        password = InputUtilities.getUserPassword("""
                                                  Please enter a valid password
                                                   1. Password must contain at least one digit [0-9].
                                                   2. Password must contain at least one lowercase Latin character [a-z].
                                                   3. Password must contain at least one uppercase Latin character [A-Z].
                                                   4. Password must contain at least one special character like ! @ # & ( ).
                                                   5. Password must contain a length of at least 8 characters and a maximum of 20 characters.""");

        // Inserting information into database
        System.out.println("Inserting data into our database...\n");

        String query = "INSERT INTO user (`first_name`, `last_name`, `email`, `password`) VALUES (?,?,?,?);";

        try {
            ps = Database.getConnection().prepareStatement(query);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);

            if (ps.executeUpdate()> 0) {
                System.out.println(firstName + " " + lastName + " your registration is completed.\n");
                //Display login menu to new user
                Login login = new Login();
                login.userLogin();
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }

    }
}
