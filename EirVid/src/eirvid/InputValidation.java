
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvid;

import eirvid.Interfaces.DataOutputInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wallace Esteves
 * Student number: 2020326
 */
public class InputValidation implements DataOutputInterface {

    public static List<String[]> validateInput(String filename) throws IOException {

        BufferedReader myReader = new BufferedReader(new FileReader(filename));
        String line = myReader.readLine();
        String[] movieArr;
        String[] movieRow;
        List<String[]> data = new ArrayList<>();
      

        movieRow = line.split(",");
        while ((line = myReader.readLine()) != null) {
            movieArr = line.split(",");
            data.add(movieArr);
            
        } return data;
 }
    @Override
    public boolean outputData(List<String[]>data){
        List<List<String>> outputList = new ArrayList<>();

        for (int row = 0; row < data.size(); row++) {
            
            List<String> dataList = new ArrayList<>();
            for (int column = 0; column < data.get(row).length; column++) {
                dataList.add(data.get(row)[column]);
            }
            outputList.add(dataList);
            System.out.println(dataList);
        }
        return true;
       
=======
package eirvid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Wallace Esteves Student number: 2020326
 */
public class InputValidation {

    public static void validateInput(String filename) throws IOException, InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {

        Connection conn = Database.getConnection();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {

                //use comma as separator 
                String[] row = line.split(cvsSplitBy);;
                String sql = "INSERT INTO `movies`  VALUES (?,?,?,?,?,?,?)";
                var statement = conn.prepareStatement(sql);
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
