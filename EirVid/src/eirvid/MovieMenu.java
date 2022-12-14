package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import java.math.BigDecimal;

public class MovieMenu {
    private String movieTitle;
    private String movieGenre;
    private BigDecimal rentPrice;

    public MovieMenu(String movieTitle, String movieGenre, String rentPrice) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.rentPrice = new BigDecimal(rentPrice);
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public BigDecimal getRentPrice() {
        return rentPrice.add(BigDecimal.ZERO);
    }

}
