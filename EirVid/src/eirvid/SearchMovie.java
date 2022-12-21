package eirvid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class SearchMovie {

    private String MovieTitle;
    private String[] genreSearch;
    private boolean rented;
    private String query;
    public ArrayList<String> rentalHistory; 
    PreparedStatement ps;
    ResultSet rs;

    public void searchMovieTitle(String movieTitle) {
        try {
            query = "SELECT * FROM movies WHERE movie_title = ?";
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, movieTitle);

            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Wrong movie title, please search again\n");
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }

            do {
                String title = rs.getString("movie_title");
                String genre = rs.getString("genre");
                String year = rs.getString("year");
                String price = rs.getString("price");
                
                new Movie(title, genre, year, price);

                System.out.println("Movie Title: " + title + "\n");
                System.out.println("Genre: " + genre + "\n");
                System.out.println("Year: " + year + "\n");
                System.out.println("Price: " + price + "\n");

            } while (rs.next());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
    }

    public String[] searchGenre() {
        return genreSearch;
    }

    public ArrayList<String> updateRentalHistory(String movieTitle) {
        
        rentalHistory = new ArrayList<>();

        rentalHistory.add(movieTitle);

        return rentalHistory;
    }

    public void getRentalHistory() {

        for (int i = 0; i < rentalHistory.size(); i++) {
            System.out.println(rentalHistory.get(i));
        }

        if (rentalHistory.isEmpty()) {
            System.out.println("Sorry, but it looks like you have not rented a movie with us yet.");
        }

    }
}
