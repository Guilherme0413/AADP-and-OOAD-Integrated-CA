package Utilities;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Common Input Tasks 
 * Includes:
 *  KEYBOARD INPUT UTILITIES
 *   getUserText
 *   getUserInt - with a range
 *   getUserInt - with a minimum
 *   getUserDouble - with a range
 * 
 * 
 * All methods are static
 * @author Ken
 */
public class InputUtilities {
    
    /*
       Some useful methods for gettong input from the user
    */
    
    /**
     * 
     * @param prompt -- message/request made to user
     * @return - the text entered by the user
     */
    public static String getUserText(String prompt){
        
                
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        
        do{
            //if input is not text, ask again
                        
            System.out.println(prompt); //output prompt
            System.out.println("Plese enter alphabetical characters ONLY.");
            try{
                
               userInput = myKB.readLine(); //read input
            }
            catch(Exception e){
                
                System.out.println("Input error!");
                userInput = ""; //set it to nothinig if invalid
            }
            
        }while (!userInput.matches("[a-zA-Z]+"));
        
        //userInput must be text
        
        return userInput;
        
    }
    
    /**
     * 
     * @param prompt -- message/request made to user
     * @param minValue - the minimum value that is valid
     * @param maxValue - the max value that is valid
     * @return - a valid int entered by user
     */
    public static int getUserInt(String prompt, int minValue, int maxValue){
        
        
          BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
           
          int userInput=0;
           
          boolean valid = false; 
           
           do{
             //prompt user for input - if not integer - output error and ask again
               System.out.println(prompt); //output prompt
               System.out.println("You must enter a value between " + minValue + " and " + maxValue );
               
            try{
                userInput = Integer.parseInt(myKB.readLine()); //read input
                valid = true;
            }
            catch(Exception e){
                
                System.out.println("That is not a number. Please try again");
                //valid stays false
            }
            
            //not valid if < minValue or > maxValie
        }while ( (!valid) || (userInput < minValue) || (userInput > maxValue));
           
           //must be valid and within the range
           return userInput;
           
    }
    
    /**
     * Prompt user with a message to enter an integer above a given value
     * repeat prompt until user enters valid value
     * 
     * @param prompt - the message displayed to user
     * @param minValue - the lowest value allowed
     * @return a valid int entered by the user
     */
    public static int getUserInt(String prompt, int minValue){
        
        
          BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
           
          int userInput=0;
           
          boolean valid = false; 
           
           do{
             //prompt user for input - if not integer - output error and ask again
               System.out.println(prompt); //output prompt
               System.out.println("You must enter a value greater than " + minValue );
               
            try{
                userInput = Integer.parseInt(myKB.readLine()); //read input
                valid = true;
            }
            catch(Exception e){
                
                System.out.println("That is not a number. Please try again");
                //valid stays false
            }
            
            //not valid if < minValue or > maxValie
        }while ( (!valid) || (userInput < minValue));
           
           //must be valid and within the range
           return userInput;
           
    }
    
    
    /**
     * 
     * Displays a prompt and requests a decimal from  user; if a non-decimal is entered
     * display error message and ask again
     * 
     * @param prompt - message displayed
     * @param minValue - minimum value that is allowed
     * @param maxValue - max value that is allowed
     * @return -- a valid decimal input by user
     */
    public static double getUserDouble(String prompt, int minValue, int maxValue){
        
       
          BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
           double userInput=0;
           boolean valid = false;
           
           do{
                //prompt user for a decimal - if not decimal - output error and ask again
               System.out.println(prompt); //output prompt
               System.out.println("You must enter a value between " + minValue + " and " + maxValue );
               
            try{
                userInput = Double.parseDouble(myKB.readLine()); //read input
                valid = true;
            }
            catch(Exception e){
                
                System.out.println("That is not a number. Please try again");
                //valid stays false
            }
            
        }while ( (!valid) || (userInput < minValue) || (userInput > maxValue));
           
           //must be valid and within the range
           return userInput;
           
    }
}
