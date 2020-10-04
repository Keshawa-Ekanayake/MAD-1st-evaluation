package com.example.it19150758;

public class BookDetails {

    private String name;
    private String publishdate;
    private String author;
    private String category;

    public BookDetails(String name, String publishdate, String authoruthor, String category) {
        this.name = name;
        this.publishdate = publishdate;
        this.author = author;
        this.category = category;
    }

    public BookDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String uuthor) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
