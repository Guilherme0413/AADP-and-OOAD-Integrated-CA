package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import eirvid.Interfaces.MovieMenuInterface;
import eirvid.Utilities.InputUtilities;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class MovieMenu implements MovieMenuInterface {
    
    private final Integer MAXIMUM_RENTAL_PERMITED = 5;
    private String movieTitle;
    private String movieGenre;
    private BigDecimal rentPrice;
    private int rentalMovieQtnd = 0;

    @Override
    public void displayMovieMenu() {
        System.out.println("Welcome to our Movie List");
        System.out.println("\n1) Search by Movie Title");
        System.out.println("\n2) Search by Movie Genre");
        System.out.println("\n3) Exit");
        int input = InputUtilities.getUserInt("Please choose an option from the list above.", 1, 3);
        switch (input) {
            case 1:
                // Call method to search movies by title
                String movieTitle = InputUtilities.getUserText("Please enter the name of the movie");
                Movie movies = new Movie(movieTitle);
                // Search database
                movies.getMovieTitle(movieTitle);
                LocalTime rentalTime = LocalTime.now();
                rentalMovieQtnd = rentalMovieQtnd + 1;
                System.out.println("Do you would like to rent another movie?");
                input = InputUtilities.getUserInt("Please choose an option from the list above.", 1, 2);
                if (input == 1) {
                    while (!hasRentalPermition(rentalTime)) {
                        System.out.println("PLease wait");
                    }
                    if (rentalMovieQtnd >= MAXIMUM_RENTAL_PERMITED) {
                        System.out.println("The rental Limited has been reached");
                    }
                    displayMovieMenu();
                } else {
                    System.out.println("Thank you");
                }

            case 2:
            // Call method to search movies by genre
        }
    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String getMovieGenre() {
        return movieGenre;
    }

    @Override
    public BigDecimal getRentPrice() {
        return rentPrice.add(BigDecimal.ZERO);
    }

    private boolean hasRentalPermition(LocalTime rentalTime) {
        return LocalTime.now().isAfter(rentalTime.plusMinutes(1));
    }

}
