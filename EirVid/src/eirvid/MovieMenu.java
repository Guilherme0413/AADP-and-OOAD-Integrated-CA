package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import eirvid.Interfaces.MovieMenuInterface;
import eirvid.Utilities.InputUtilities;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MovieMenu implements MovieMenuInterface {

    private String movieTitle;
    private String movieGenre;
    private String searchGenre;
    private BigDecimal rentPrice;
    private int input;
    SearchMovie eirvid = new SearchMovie();
    Rent rental = new Rent();
    ArrayList<String> rentalHistory = new ArrayList<>();

    @Override
    public void displayMovieMenu() {
        System.out.println("\nEirVid Menu");
        System.out.println("\n1. Search by Movie Title");
        System.out.println("\n2. Search by Movie Genre");
        System.out.println("\n3. See your rental history");
        System.out.println("\n4. Get movie recommendations");
        System.out.println("\n5. Change your password");
        System.out.println("\n6. Exit");
        input = InputUtilities.getUserInt("Please choose an option from the list above.", 1, 6);
        switch (input) {
            case 1:
                // Search and rent a movie
                movieTitle = InputUtilities.getUserText("Please enter the name of the movie");
                eirvid.searchMovieTitle(movieTitle);
                rental.setRentTimer();
                //eirvid.updateRentalHistory(movieTitle);
                System.out.println("Updating your rental history...");
                rentalHistory.add(movieTitle);

                //For this prototype: when a customer is charged, output the customer, movie, and price to the console
                System.out.println("Thanks for renting with us, this is a summary of your order: \n");
                System.out.println("Customer: " + Customer.getRenterName());
                System.out.println("Movie: " + Movie.getMovieTitle());
                System.out.println("Price: " + Movie.getPrice());

                returnToMenu();
                break;
            case 2:
                // Call method to search movies by genre
                searchGenre = InputUtilities.getUserText("Please enter the name of the genre");
                SearchMovie eirvid = new SearchMovie();
                eirvid.searchGenre(searchGenre);
                returnToMenu();
                break;

            case 3:
                System.out.println("\nThese are the movies you have rented before:\n");
                //eirvid.getRentalHistory();
                for (int i = 0; i < rentalHistory.size(); i++) {
                    System.out.println(rentalHistory.get(i));
                    System.out.println("\n");
                }
                returnToMenu();
                break;
            case 4:
                System.out.println("\nThese are our top 5 most rented movies:\n");
                ArrayList<String> list = Recommend.getRating();
                Recommend.topFiveRated(list);
                returnToMenu();
                break;
            case 5:

            case 6:
                System.out.println("Exiting...");
        }
    }

    private void returnToMenu() {
        int returnToMenu = InputUtilities.getUserInt("Would you like to return to the main menu?\n 0. No\n 1. Yes", 0, 1);

        if (returnToMenu == 1) {
            displayMovieMenu();
        } else {
            System.out.println("Thank you, exiting program...");
            System.exit(0);
        }
    }

}
