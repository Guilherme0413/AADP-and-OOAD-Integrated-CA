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
       
    }
}
