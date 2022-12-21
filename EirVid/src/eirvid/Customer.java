package eirvid;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This is a Customer class that contains three static variables, firstName,
 * lastName and email. It also contains a constructor that takes in three
 * parameters, firstName, lastName and email. The values of these parameters are
 * stored in the static variables. The class also contains two static methods,
 * getRenterName and getRenterEmail, which return the values of the firstName,
 * lastName and email variables.
 *
 * @author Danrlei Martins - Student Number: 2020322
 */
public class Customer {

    static private String firstName;
    static private String lastName;
    static private String email;
    static private boolean canRent;

    public Customer(String firstName, String lastName, String email, boolean canRent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.canRent = canRent;
    }

    public static String getRenterName() {
        return firstName + " " + lastName + "\n";
    }

    public static String getRenterEmail() {
        return email;
    }

    public static boolean isCanRent() {
        return canRent;
    }

    public static void setCanRent(boolean canRent) {
        Customer.canRent = canRent;
    }
    

    //@Override
    public static boolean changePassword(String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        PreparedStatement ps;

        // SQL query
        String query = "UPDATE user SET password = ? WHERE email = ? ";

        try {
            ps = Database.getConnection().prepareStatement(query);

            ps.setString(1, newPassword);
            ps.setString(2, getRenterEmail());

            if (ps.executeUpdate() > 0) {
                System.out.println("You have successfuly changed your password.\n");
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
