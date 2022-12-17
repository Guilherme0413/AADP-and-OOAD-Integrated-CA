/*
Algorithms, Architecture and Design Patterns
Object Oriented Analysis and Design
Integrated Continuous Assessment 3
 */
package eirvid;


import eirvid.Interfaces.DataOutputInterface;
import java.util.List;

import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author Guri's Group
 */
public class EirVid {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {

        // Run EirVid system
        LoginMenu menu = new LoginMenu();
        menu.displayMenu();
        
        //list of commands to show the output of the csv file 
     //  List<String[]> data =InputValidation.validateInput("movie_dataset_CA.csv");
      //  DataOutputInterface outputData = new InputValidation();
      // outputData.outputData(data);
        
        // Testing getting name from database
        //Renter renter = new Renter();
        //renter.getRenterName("john@cct.ie");
        
        // Testing change password method
        //renter.changePassword("silvamartins@cct.ie", "Danrle1!95");

        
        // Testing insert data from csv into database
        //InputValidation.validateInput("movie_dataset_CA.csv");

    }
}
