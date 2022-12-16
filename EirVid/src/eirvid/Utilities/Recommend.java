package eirvid.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public static ArrayList<String> topViewer(int user) {
        topMoviesUser = new ArrayList<>();
        topMovieID = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.movie_dataset");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_dataset", "root", "");
            Statement movies = connect.createStatement();

            ResultSet top = movies.executeQuery("select movie_id from rating where user_id = " + user +
                    " order by ratings desc limit 7");
            while (top.next()) {
                topMovieID.add(top.getInt("movie_id"));
            }

            if (top != null) {
                top.close();
            }

            int thisID = 0;
            for (int i = 0; i < topMovieID.size(); i++) {
                thisID = topMovieID.get(i);
                ResultSet mName = movies.executeQuery("select movie_name from movie where movie_id = " + thisID);
                if (mName.next()) {
                    topMoviesUser.add(mName.getString("movie_name").trim());
                }
                if (mName != null) {
                    mName.close();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topMoviesUser;
    }

    public ArrayList<String> Result(int user) {
        rec = new ArrayList<>();
        int sizeOfList = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement topMovies = connect.createStatement();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connec = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement topSim = connec.createStatement();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement u = conn.createStatement();

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement mName = c.createStatement();

            int recommendCount = 0, thisMovieId = 0, simMovieID = 0;

            ResultSet usersTop = topMovies.executeQuery("select movie_id from rating where user_id = " + user +
                    " order by ratings desc limit 10");

            while (recommendCount < 20 && usersTop.next()) {
                thisMovieId = usersTop.getInt("movie_id");
                ResultSet ts = topSim.executeQuery("select simid from similar where mid = " + thisMovieId);
                while (ts.next()) {
                    if (recommendCount < 20) {
                        simMovieID = ts.getInt("simid");
                        ResultSet checkUser = u.executeQuery("select count(*) from rating where user_id = " + user +
                                " and movie_id = " + simMovieID);
                        if (checkUser.next()) {
                            if (checkUser.getInt(1) == 0) {
                                ResultSet movieName = mName.executeQuery("select movie_name from movie where "
                                        + "movie_id = " + simMovieID);
                                if (movieName.next()) {
                                    recommendCount++;
                                    rec.add(movieName.getString("movie_name").trim());
                                }
                                if (movieName != null) {
                                    movieName.close();
                                }
                            }
                        }
                        if (checkUser != null) {
                            checkUser.close();
                        }
                    }

                }
                if (ts != null) {
                    ts.close();
                }
            }
            if (usersTop != null) {
                usersTop.close();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rec;
    }

    public static void addMovie(String name, int rating, int user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement newMovie = c.createStatement();

            Class.forName("com.mysql.jdbc.Driver");
            Connection mIDConnect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_recommend", "root", "");
            Statement mIDStat = mIDConnect.createStatement();

            ResultSet mCount = newMovie.executeQuery("select count(*) from movie");
            int movies = 0;
            if (mCount.next()) {
                movies = mCount.getInt(1);
            }
            if (mCount != null) {
                mCount.close();
            }

            ResultSet ifExists = newMovie
                    .executeQuery("select count(*) from movie where movie_name = '" + name.trim() + "'");
            int getCount = 0, getMID = 0;
            if (ifExists.next()) {
                getCount = ifExists.getInt(1);
                if (getCount == 0) {
                    newMovie.executeUpdate("insert into movie (movie_id, movie_name, url) values (" + (movies + 1)
                            + ", '" + name + "', 'NULL')");
                    newMovie.executeUpdate("insert into rating (user_id, movie_id, ratings) values (" + user + ","
                            + (movies + 1) + "," + rating + ")");
                } else {
                    ResultSet mIdRes = mIDStat
                            .executeQuery("select movie_id from movie where movie_name = '" + name + "'");
                    if (mIdRes.next()) {
                        getMID = mIdRes.getInt("movie_id");
                    }
                    if (mIdRes != null) {
                        mIdRes.close();
                    }
                    mIDStat.executeUpdate("insert into rating (user_id, movie_id, ratings) values (" + user + ","
                            + getMID + "," + rating + ")");
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}