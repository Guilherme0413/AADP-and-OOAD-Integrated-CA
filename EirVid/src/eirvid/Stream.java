package eirvid;

public class Stream implements Visualization {
    private String title;
    private String genre;
    private String author;
    private int duration;
    private boolean view;

    public Stream(String title, String genre, int duration, boolean view) {
        this.title = "Not find";
        this.genre = "Not find";
        this.author = "Not find";
        this.duration = 0;
        this.view = false;
    }

    // constructor with all the Title and Author find all the others defaults values
    public Stream(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // constructor with all the Title and Author has less views
    public Stream(String title, String genre, String author, int duration) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
    }

    // methods Gets and set in most of the atributes with less views
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        String info = "title" + title + "\n";
        info = "genre" + genre + "\n";
        info = "author" + author + "\n";
        info = "duration" + duration + "\n";
        if (view) {
            info = "viewed? yes";
        } else {
            info = "not viewed? no";
        }
        return info;
    }

    @Override
    public void checkView() {
        this.view = true;
    }

    @Override
    public boolean isViewed() {
        return view;
    }

    @Override
    public int timeViewed() {
        return duration;
    }

}
