package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import eirvid.Interfaces.MovieMenuInterface;
import java.math.BigDecimal;

public class MovieMenu implements MovieMenuInterface {
    private String movieTitle;
    private String movieGenre;
    private BigDecimal rentPrice;
    
    @Override
    public void displayMovieMenu(String movieTitle, String movieGenre, String rentPrice) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.rentPrice = new BigDecimal(rentPrice);
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
