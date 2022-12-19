package eirvid;

import eirvid.Interfaces.LoginMenuInterface;
import eirvid.Utilities.InputUtilities;

/**
 *
 * @author Guilherme Oliveira 2020316 This class regards the login menu
 */
public class LoginMenu implements LoginMenuInterface {

    @Override
    public void displayMenu() {

        Login login = new Login();
        CreateAccount register = new CreateAccount();

        System.out.println("Welcome to EirVid Movie Rental System");
        System.out.println("\n1. Login");
        System.out.println("\n2. Create account");
        System.out.println("\n3. Exit");
        int input = InputUtilities.getUserInt("\nPlease choose an option", 1, 3);

        do {
            switch (input) {
                case 1:
                    login.loginMenu();
                    break;
                case 2:
                    register.userRegister();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;
            }
        } while (input != 3);

    }

}
