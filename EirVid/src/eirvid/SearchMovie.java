package eirvid;

import eirvid.Utilities.InputUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wallace Esteves - 2020326
 * @author Caio Machado - 2020351
 */
public class SearchMovie {

    private String MovieTitle;
    private String query;
    public ArrayList<String> rentalHistory;
    PreparedStatement ps;
    ResultSet rs;
    private String id;
    private String title;
    private String genre;
    private String genreList;
    private String year;
    private String price;

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
                title = rs.getString("movie_title");
                genre = rs.getString("genre");
                year = rs.getString("year");
                price = rs.getString("price");

                new Movie(title, genre, year, price);

                System.out.println("\nMovie Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Year: " + year);
                System.out.println("Price: " + price + "\n");

            } while (rs.next());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
    }

    public void searchGenre(String genre) {

        try {
            query = "SELECT movie_id, movie_title, genre, year, price FROM movies WHERE genre LIKE ? LIMIT 10";
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, "%" + genre + "%");
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Wrong genre, please search again\n");
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }
            //Loop to match movie genre with database
            while (rs.next()) {
                id = rs.getString(1);
                title = rs.getString(2);
                genreList = rs.getString(3);
                year = rs.getString(4);
                price = rs.getString(5);

                System.out.println("\nMovie ID: " + id);
                System.out.println("Movie Title: " + title);
                System.out.println("Genre: " + genreList);
                System.out.println("Year: " + year);
                System.out.println("Price: " + price + "\n");
            }
            //rentAfterGenreSearch();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
    }

    public void rentAfterGenreSearch() {

        int input = InputUtilities.getUserInt("Would you like to rent any of these movies?\n 0. No\n 1. Yes", 0, 1);

        if (input == 1) {
            int movieId = InputUtilities.getUserInt("Please enter the movie ID", 0, 100);
            String sql = "SELECT movie_title, genre, year, price FROM movies WHERE movie_id = ?";

            try {
                ps = Database.getConnection().prepareStatement(sql);
                ps.setInt(1, movieId);
                rs = ps.executeQuery();

                do {
                    id = rs.getString("movie_id");
                    title = rs.getString("movie_title");
                    genreList = rs.getString("genre");
                    year = rs.getString("year");
                    price = rs.getString("price");

                    new Movie(title, genreList, year, price);

                    System.out.println("\nMovie ID: " + id);
                    System.out.println("Movie Title: " + title);
                    System.out.println("Genre: " + genreList);
                    System.out.println("Year: " + year);
                    System.out.println("Price: " + price + "\n");
                    Rent rent = new Rent();
                    rent.setRentTimer();

                } while (rs.next());
            } catch (Exception e) {

            }

        } else {
            System.out.println("Returning to main menu\n");
            MovieMenu menu = new MovieMenu();
            menu.displayMovieMenu();
        }
    }

}
