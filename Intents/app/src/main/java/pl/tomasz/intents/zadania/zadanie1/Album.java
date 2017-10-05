package pl.tomasz.intents.zadania.zadanie1;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Album {

    private String title;
    private String artist;
    private String year;
    private int imageId;

    public Album(String title, String artist, String year, int imageId) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.imageId = imageId;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
