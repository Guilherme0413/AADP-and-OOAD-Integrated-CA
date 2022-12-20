package eirvid;

import eirvid.Utilities.InputUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author
 */
public class SearchMovie {

    private String movieTitle;
    private String[] genre;
    // private int duration;
    private boolean rented;

    public SearchMovie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String searchMovieTitle(String movieTitle) {
        PreparedStatement ps;
        ResultSet rs;

        String query = "SELECT * FROM movies WHERE movie_title = ?";

        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, movieTitle);

            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Wrong movie title, please search again\n");
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }

            //Loop to match movie title with database
            do {
                String col1 = rs.getString("movie_title");
                String col2 = rs.getString("genre");
                String col3 = rs.getString("year");
                String price = rs.getString("price");

                System.out.println("Movie Title: " + col1 + "\n");
                System.out.println("Genre: " + col2 + "\n");
                System.out.println("Year: " + col3 + "\n");

                int input = InputUtilities.getUserInt("Would you like to rent this movie?\n 0 = No\n 1 = Yes", 0, 1);

                switch (input) {                   
                    case 1:
                    // Rent movie (boolean) and add movie to the list)
                    // Timer - 1 min ????????
                    // When isRented = false -> Output customer (getRenterName), movie (movieTitle), and price (price string)
                    case 2:
                    // Go back to search
                }

            } while (rs.next());

        } catch (Exception e) {

        }

        return movieTitle;
    }

    public String searchMovieGenre(String genre) {
        PreparedStatement ps;
        ResultSet rs;

        List<String[]> list = new ArrayList<>();
        String query = "SELECT movie_id, movie_title, genre, year FROM movies WHERE genre LIKE '%?%' ";
        
        try {
            ps = Database.getConnection().prepareStatement(query);

            //Set strings for query missing values
            ps.setString(1, genre);

            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Wrong genre, please search again\n");
                MovieMenu menu = new MovieMenu();
                menu.displayMovieMenu();
            }

            //Loop to match movie genre with database
            while (rs.next());
            {
                String id = rs.getString(1);
                String title = rs.getString(2);
                String genres = rs.getString(3);
                String year = rs.getString(4);
                list.add(new String[]{id, title, genres, year});

                for (String[] str : list) {
                    System.out.println(Arrays.toString(str));
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
        return genre;
    }

    public boolean isRented() {
        return rented;
    }

//    public int getDuration(){
//        return duration;
//    }
//   public void setDuration (int duration) {
//       this.duration = duration;
//   }
}
