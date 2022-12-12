/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvid;

import java.util.Scanner;

/**
 *
 * @author Guilherme Oliveira 2020316
 * This class regards the login menu
 */
public class LoginMenu {
    
    private static void displayMenu() {
        System.out.println("Welcome to EirVid Movie Rental System");
        System.out.println("\n1) Login");
        System.out.println("\n2) Create account");
        System.out.println("\n3) Exit");
    }

    private static void loginMenuInput() {
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        while (userInput != 3) {
            switch (userInput) {
                case 1:
                    // LoginMenu
                    //Login.userLogin();
                    break;
                case 2:
                    // Create account
                    break;
            }
            displayMenu();
        }
    }
    
}
