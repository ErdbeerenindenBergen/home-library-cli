package com.homelibrary.aquisitions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Book {

    private int id;

    @JsonProperty("goodreads")
    private String goodreadsId;

    @JsonProperty("librarything")
    private String librarythingId;
    private String title;
    private String subtitle;

    private Object publishers;
//    @JsonProperty("first_sentence")
//    private List<Object> firstSentence;

    private List<Author> allAuthors;

    //variable made to store author keys below
    @JsonProperty("authors")
    private List<Object> authors;

//    private String publishingLocation;

    @JsonProperty("publish_date")
    private String publicationDate;
    private String ISBN;
//    private String language;

    @JsonProperty("number_of_pages")
    private int numberOfPages;
//    private String shelfLocation;
//    private String edition;

    public Book() {
    }

    public Book(int id, String title, String subtitle, String publicationDate, String ISBN, int numberOfPages, Object[] publishers) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        this.numberOfPages = numberOfPages;
        this.publishers = publishers;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

//    public List<Object> getFirstSentence() {
//        return firstSentence;
//    }
    public List<Object> getAuthors() {
        return authors;
    }

    public void setAllAuthors(List<Author> allAuthors) {
        this.allAuthors = allAuthors;
    }

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    public String getPublishers() {
        String finalPublishers = publishers.toString();
        finalPublishers = finalPublishers.substring(1,finalPublishers.length()-1);
        return finalPublishers;
    }

    public String getPublicationDate() {
        return publicationDate;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPublishers(Object publishers) {
        this.publishers = publishers;
    }

    public void setAuthors(List<Object> authors) {
        this.authors = authors;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}