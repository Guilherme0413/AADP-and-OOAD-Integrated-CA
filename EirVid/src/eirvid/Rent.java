package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import eirvid.Interfaces.RentInterface;
import eirvid.Utilities.InputUtilities;
import java.time.LocalTime;

public class Rent implements RentInterface {

    private int rentalMovieQtnd = 0;
    private int input;
    private final int MAXIMUM_RENTAL_PERMITED = 1;
    public String movieTitle;

    private boolean hasRentalPermition(LocalTime rentalTime) {
        return LocalTime.now().isAfter(rentalTime.plusMinutes(1));
    }

    @Override
    public void setRentTimer() {
        LocalTime rentalTime = LocalTime.now();
        rentalMovieQtnd = rentalMovieQtnd + 1;

        input = InputUtilities.getUserInt("Would you like to rent this movie?\n 0. No\n 1. Yes", 0, 1);

        if (input == 1) {
            Customer.setCanRent(false);    
            
            while (!hasRentalPermition(rentalTime)) {
                System.out.println("Rental currently active. Please wait 1 minute...");
            }
            if (rentalMovieQtnd >= MAXIMUM_RENTAL_PERMITED) {
                System.out.println("The rental Limited has been reached");
            }
        }
    }

}
