package eirvid;

/**
 * This is a class called Movie that contains the variables movieTitle, genre,
 * year, and price. These variables are all static, meaning they can be used in
 * any object of the Movie class. The constructor takes in four parameters,
 * movieTitle, genre, year, and price, and assigns them to their respective
 * fields. It also contains four getter methods which can be used to retrieve
 * the values of the fields.
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
