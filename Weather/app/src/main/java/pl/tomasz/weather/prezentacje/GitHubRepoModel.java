package pl.tomasz.weather.prezentacje;

/**
 * Created by Tomasz on 05.10.2017.
 */

public class GitHubRepoModel {

    private String name;
    private String address;
    private String language;
    private boolean isPrivate;

    public GitHubRepoModel(){

    }

    public GitHubRepoModel(String name, String address, String language, boolean isPrivate) {
        this.setName(name);
        this.setAddress(address);
        this.setLanguage(language);
        this.setPrivate(isPrivate);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
