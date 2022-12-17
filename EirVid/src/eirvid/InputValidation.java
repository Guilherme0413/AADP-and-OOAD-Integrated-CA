/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvid;

import eirvid.Interfaces.DataOutputInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wallace Esteves Student number: 2020326
 */
public class InputValidation {

    public static void validateInput(String filename) throws IOException, InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
      
        String myUrl = "jdbc:mysql://localhost:3306/movies_dataset";
        String user = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(myUrl, user, password);
        String csvFile = "movie_dataset_CA.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                //use comma as separator 
                String[] row = line.split(cvsSplitBy);
                //       String sql = "INSERT INTO movies VALUES (?,?,?,?,?)";
                String sql = "INSERT INTO `movies`  VALUES (?,?,?,?,?,?,?)";
                var statement = conn.prepareStatement(sql);
                //  statement.setString(1, row[1]);
                statement.setInt(1, Integer.parseInt(row[0]));
                statement.setString(2, row[1]);
                statement.setString(3, row[2]);
                statement.setString(4, row[3]);
                statement.setString(5, row[4]);
                statement.setInt(6, Integer.parseInt(row[5]));
                statement.setInt(7, Integer.parseInt(row[6]));
                int rowAffected = statement.executeUpdate();
                System.out.println(rowAffected + " row(s) affected");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.close();
            }
        }

    
}
}