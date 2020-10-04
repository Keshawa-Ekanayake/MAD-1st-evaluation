package com.example.wishtoread;

public class BookList {
    private String name, author, pdate, category;

    public BookList(String name, String author, String pdate, String category) {
        this.name = name;
        this.author = author;
        this.pdate = pdate;
        this.category = category;
    }

    public BookList(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
