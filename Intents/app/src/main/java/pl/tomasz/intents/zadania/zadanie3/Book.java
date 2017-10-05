package pl.tomasz.intents.zadania.zadanie3;

/**
 * Created by Tomasz on 29.09.2017.
 */

public class Book {

    private String title;
    private String desc;

    public Book(String title, String desc) {
        this.setTitle(title); //this.title = title;
        this.setDesc(desc);   // this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
