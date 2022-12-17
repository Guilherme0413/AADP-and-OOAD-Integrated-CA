/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvid;

import eirvid.Interfaces.DataInputInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author Wallace Esteves
 * Student number: 2020326
 */
public class FileInput implements DataInputInterface{
    private BufferedReader myReader;
    
    public FileInput(String filename) throws FileNotFoundException, IOException{
        myReader = new BufferedReader (new FileReader(filename));
    }
    
    @Override
    public String nextLine(){
        try {
            return  myReader.readLine();
        }catch(IOException ex){
            Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }
}
