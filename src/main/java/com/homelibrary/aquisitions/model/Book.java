package com.homelibrary.aquisitions.model;

import com.fasterxml.jackson.annotation.JsonKey;

import java.util.Map;

public class Book {

    private int id;
    private String title;
    private String subtitle;
    private Author author;

    private Map authors;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishingLocation() {
        return publishingLocation;
    }

    public void setPublishingLocation(String publishingLocation) {
        this.publishingLocation = publishingLocation;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Map getAuthors() {
        return this.authors;
    }
}