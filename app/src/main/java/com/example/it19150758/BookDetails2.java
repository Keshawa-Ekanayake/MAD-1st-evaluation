package com.example.it19150758;

public class BookDetails2 {

    private String name;
    private String publishdate;
    private String author;
    private String category;

    public BookDetails2(String name, String publishdate, String author, String category) {
        this.name = name;
        this.publishdate = publishdate;
        this.author = author;
        this.category = category;
    }

    public BookDetails2() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
