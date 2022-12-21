/*
Algorithms, Architecture and Design Patterns
Object Oriented Analysis and Design
Integrated Continuous Assessment 3
 */
package eirvid;

import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author Caio Machado - 2020351
 * @author Danrlei Martins - 2020322
 * @author Guilherme Oliveira - 2020316
 * @author Wallace Esteves - 2020326
 * @author Willian Amaral - 2020487
 */
public class EirVid {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {

                
        // Insert data from csv into database
        //InputValidation.validateInput("movie_dataset_CA.csv");

        // Run EirVid system
        LoginMenu menu = new LoginMenu();
        menu.displayMenu();
    }
}
