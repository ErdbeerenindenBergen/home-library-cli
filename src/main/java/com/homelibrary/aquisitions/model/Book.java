package com.homelibrary.aquisitions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Book {

    private int id;
    private String title;
    private String subtitle;

    private List<Author> allAuthors;

    //variable made to store author keys below
    @JsonProperty("authors")
    private List<Object> authors;

    private List<String> authorNames;
    private String publishingLocation;
    private String publishingDate;
    private String ISBN;
    private String language;
    private int pageTotal;
    private String publisher;
    private String shelfLocation;
    private String edition;


    public Book() {
    }

    public Book(int id, String title, String subtitle, String author, String publishingLocation, String publishingDate, String ISBN, String language, int pageTotal, String publisher, String shelfLocation, String edition) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.publishingLocation = publishingLocation;
        this.publishingDate = publishingDate;
        this.ISBN = ISBN;
        this.language = language;
        this.pageTotal = pageTotal;
        this.publisher = publisher;
        this.shelfLocation = shelfLocation;
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<Object> getAuthors() {
        return authors;
    }

    public void setAllAuthors(List<Author> allAuthors) {
        this.allAuthors = allAuthors;
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }
}