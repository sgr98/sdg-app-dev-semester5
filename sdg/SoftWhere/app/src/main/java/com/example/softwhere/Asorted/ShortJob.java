package com.example.softwhere.Asorted;

/*
ShortJob is used as a data structure for JobsRecylerViewAdapter.
 */
public class ShortJob {

    private int id;
    private String title;
    private String salary;
    private String imageURL;

    public ShortJob(int id, String title, String salary, String imageURL) {
        this.id = id;
        this.title = title;
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
        return "ShortJob{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
