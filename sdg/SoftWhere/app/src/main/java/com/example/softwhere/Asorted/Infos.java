package com.example.softwhere.Asorted;

/*
Infos is used as a data structure for InfoRecylerViewAdapter and InfoDetailsActivity.
 */
public class Infos {

    private int id;
    private String title;
    private String description;
    private String contents;
    private String imageURL;

    public Infos(int id, String title, String description, String contents, String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.contents = contents;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contains) {
        this.contents = contains;
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
                ", contains='" + contents + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
