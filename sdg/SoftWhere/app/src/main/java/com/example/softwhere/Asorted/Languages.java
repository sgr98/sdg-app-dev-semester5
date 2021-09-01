package com.example.softwhere.Asorted;

/*
Languages is used as a data structure for LanguagesRecylerViewAdapter.
 */
public class Languages {

    private int id;
    private String title;
    private String type;
    private String description;
    private String status;
    private String color = "#000000";

    public Languages(int id, String title, String type, String description, String status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguageColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
