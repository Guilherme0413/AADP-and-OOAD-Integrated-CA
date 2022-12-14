
package eirvid.Interfaces;

import java.sql.Connection;

/**
 *
 * @author Danrlei Martins 
 * Student Number: 2020322
 */
public interface DatabaseInterface {
    
    public Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
