package eirvid;

import eirvid.Interfaces.RenterInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danrlei Martins - Student Number: 2020322
 */
public class Renter implements RenterInterface {

    @Override
    public String[] getRenterName(String email) {
        PreparedStatement ps;
        ResultSet rs;
        String[] name = new String[2];

        // SQL query to authenticate user
        String query = "SELECT first_name, last_name FROM user WHERE email = ? ";

        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                name[0] = rs.getString("first_name");
                name[1] = rs.getString("last_name");
                System.out.println(name[0] + " " + name[1]);
            }
            ps.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public boolean changePassword(String email, String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        PreparedStatement ps;

        // SQL query
        String query = "UPDATE user SET password = ? WHERE email = ? ";

        try {
            ps = Database.getConnection().prepareStatement(query);

            ps.setString(1, newPassword);
            ps.setString(2, email);

            if (ps.executeUpdate() > 0) {
                System.out.println("You have successfuly changed your password.\n");
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
