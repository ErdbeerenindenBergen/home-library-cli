package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Author;

import java.util.List;

public interface AuthorDao {

    Author getAuthor(String authorId);

    List<Author> getAuthorsByBook(int ISBN);

    Author createAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int authorId);

    void addAuthorToBook(String ISBN, int authorId);

    void removeAuthorFromBook(String ISBN, int authorId);
}
