package eirvid;

import eirvid.Interfaces.RenterInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danrlei Martins - Student Number: 2020322
 */
public class Customer implements RenterInterface {

    static private String firstName;
    static private String lastName;
    static private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static String getRenterName() {
        return firstName + " " + lastName + "\n";
    }
    
    public String getRenterEmail(){
        return email;
    }

    @Override
    public boolean changePassword(String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
