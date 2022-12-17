package eirvid.Interfaces;

import eirvid.MovieMenu;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
public interface RentInterface {

    public void RentMovie(String clientName, MovieMenu movie, String returnDateString) throws IOException, NullPointerException;

    public void updateOverdueFee();

    public String getClientName();

    public void setClientName(String clientName) throws IOException;
    
    public BigDecimal getOverdueFee();
}
