package com.homelibrary.aquisitions.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private String name;
    private List<Book> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBookToShelf(boolean isBookAdded, Book book) {
        if (isBookAdded) {
            books.add(book);
            System.out.println("Your book, \"" + book.getTitle() + ",\" has been added to the shelf.");
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
