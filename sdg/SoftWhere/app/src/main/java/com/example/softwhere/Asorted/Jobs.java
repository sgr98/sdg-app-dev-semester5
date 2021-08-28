package com.example.softwhere.Asorted;

public class Jobs {

    private int id;
    private String title;
    private String description;
    private String skills;
    private String link;
    private String salary;
    private String imageURL;

    public Jobs(int id, String title, String description, String skills, String link, String salary, String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.link = link;
        this.salary = salary;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", skills='" + skills + '\'' +
                ", link='" + link + '\'' +
                ", salary='" + salary + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
