package pl.itgenerator.szkolenia.layouts;

/**
 * Created by Tomasz on 22.09.2017.
 */

public class Movie {

    private String title;
    private int length;

    public Movie(String title, int length){
        this.setTitle(title);
        this.setLength(length);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
