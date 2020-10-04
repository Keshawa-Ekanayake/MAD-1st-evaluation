package com.example.it19150826_mad;

public class borrowedBooks {

    private String title, bDate, rDate, lib, id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public borrowedBooks(String title, String bDate, String rDate, String lib) {
        this.title = title;
        this.bDate = bDate;
        this.rDate = rDate;
        this.lib = lib;
    }

    public borrowedBooks() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }
}
