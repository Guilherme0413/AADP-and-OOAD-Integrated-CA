package eirvid;

/**
 *
 * @author Danrlei Martins - 2020322
 */
public class Movie {

    static private String movieTitle;
    static private String genre;
    static private String year;
    static private String price;

    public Movie(String movieTitle, String genre, String year, String price) {
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public static String getMovieTitle() {
        return movieTitle;
    }

    public static String getGenre() {
        return genre;
    }

    public static String getYear() {
        return year;
    }

    public static String getPrice() {
        return price;
    }

}
