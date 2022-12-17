package eirvid;

import eirvid.Utilities.InputUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author
 */
public class Movie {

    private String movieTitle;
    private String[] genre;
    // private int duration;
    private boolean rented;

    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle(String movieTitle) {
        //
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

                System.out.println("Movie Title: " + col1 + "\n");
                System.out.println("Genre: " + col2 + "\n");
                System.out.println("Year: " + col3 + "\n");
                
                int input = InputUtilities.getUserInt("Would you like to rent this movie?\n 0 = No\n 1 = Yes", 0, 1);
                
                switch(input){
                    
                    case 1:
                        // Rent movie
                    case 2:
                        // Go back to search
                }
                
            } while (rs.next());

        } catch (Exception e) {

        }

        return movieTitle;
    }

    public String[] getGenre() {
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
