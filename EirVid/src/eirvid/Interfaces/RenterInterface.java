package eirvid.Interfaces;

/**
 *
 * @author Danrlei Martins 
 * Student Number: 2020322
 */
public interface RenterInterface {
    
    public String [] getRenterName (String userEmail);
    
    public boolean changePassword(String email, String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
