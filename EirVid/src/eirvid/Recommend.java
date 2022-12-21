package eirvid;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Caio Machado - Student Number: 2020351
 */

class Recommend {

    // recommended movie names
    static ArrayList<String> rec;
    static ArrayList<String> topMoviesUser;
    static ArrayList<Integer> topMovieID;
    static ArrayList<String> topMovies;
    static PreparedStatement ps;
    static ResultSet rs;
    private static String query;
    public static String[] topFiveMovies;

    public static ArrayList<String> getRating() {

        topMovies = new ArrayList<>();
        try {

            query = "SELECT movie_title FROM movies ORDER BY views DESC LIMIT 5";
            ps = Database.getConnection().prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                String row = rs.getString("movie_title");
                topMovies.add(row);

            }
        } catch (Exception e) {

        }

        return topMovies;
    }

    public static String[] topFiveRated(ArrayList<String> list) {

        topFiveMovies = new String[5];

        for (int i = 0; i < 5; i++) {
            topFiveMovies[i] = list.get(i);
            System.out.println(topFiveMovies[i]);
        }

        return topFiveMovies;
    }
    
}