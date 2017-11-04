package pl.atk.playground;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class Application implements Serializable{

    private String name;
    private String logoUrl;
    private String desc;
    private float rating;

    public Application(String name, String url, String desc, float rating) {
        this.setName(name);
        this.setLogoUrl(url);
        this.setDesc(desc);
        this.setRating(rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
