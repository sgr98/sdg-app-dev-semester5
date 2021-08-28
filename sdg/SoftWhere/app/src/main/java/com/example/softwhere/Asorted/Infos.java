package com.example.softwhere.Asorted;

public class Infos {

    private int id;
    private String title;
    private String description;
    private String contains;
    private String imageURL;

    public Infos(int id, String title, String description, String contains, String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.contains = contains;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Infos{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contains='" + contains + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
