package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import eirvid.Interfaces.MovieMenuInterface;
import eirvid.Utilities.InputUtilities;
import java.math.BigDecimal;

public class MovieMenu implements MovieMenuInterface {

    private String movieTitle;
    private String movieGenre;
    private BigDecimal rentPrice;

    @Override
    public void displayMovieMenu() {
        System.out.println("Welcome to our Movie List");
        System.out.println("\n1. Search by Movie Title");
        System.out.println("\n2. Search by Movie Genre");
        System.out.println("\n3. Exit");
        int input = InputUtilities.getUserInt("\nPlease choose an option from the list above.", 1, 3);

        do {
            switch (input) {
                case 1:
                    // Call method to search movies by title
                    String movieTitle = InputUtilities.getUserText("Please enter the name of the movie");
                    SearchMovie titleSearch = new SearchMovie(movieTitle);
                    // Search database
                    titleSearch.searchMovieTitle(movieTitle);
                case 2:
                    // Call method to search movies by genre
                    String genre = InputUtilities.getUserText("Please enter the genre type");
                    SearchMovie genreSearch = new SearchMovie("");
                    genreSearch.searchMovieGenre(genre);
            }
        } while (input != 3);
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

}
