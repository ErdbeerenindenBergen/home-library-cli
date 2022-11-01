package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Book;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface BookDao {

    public Book getBook(int ISBN);

    public List<Book> findAll();

    public Book mapRowToBook(SqlRowSet rowSet);

    List<Book> getBooksByTitle(String title);

    public void createBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(int ISBN);

}
