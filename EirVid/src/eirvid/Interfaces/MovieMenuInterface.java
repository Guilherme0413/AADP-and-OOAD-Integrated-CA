package eirvid.Interfaces;

import java.math.BigDecimal;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
public interface MovieMenuInterface {
    
    public void displayMovieMenu(String movieTitle, String movieGenre, String rentPrice);
    
    public String getMovieTitle();
    
    public String getMovieGenre();
    
    public BigDecimal getRentPrice();
    
}
