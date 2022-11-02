package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao {

    JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public Book getBookFromDatabase(String ISBN) {
        Book book = null;
        String sql = "SELECT isbn, title, subtitle, publishers, publish_date, number_of_pages FROM book WHERE isbn = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ISBN);
        if (results.next()) {
            book = mapRowToBook(results);
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT isbn, title, subtitle, publishers, publish_date, number_of_pages FROM book;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            books.add(mapRowToBook(results));
        }
        return books;
    }

    @Override
    public Book mapRowToBook(SqlRowSet rowSet) {
        Book book = new Book();
        book.setISBN(String.valueOf(rowSet.getInt("isbn")));
        book.setTitle(rowSet.getString("title"));
        book.setSubtitle(rowSet.getString("subtitle"));
        book.setNumberOfPages(rowSet.getInt("number_of_pages"));
        book.setPublishers(rowSet.getString("publishers"));
        return book;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT isbn, title, subtitle, publishers, publish_date, number_of_pages FROM book WHERE title LIKE '%?%';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
        while(results.next()) {
            books.add(mapRowToBook(results));
        }
        return books;
    }

    @Override
    public void createBook(Book book) {
        String sql = "INSERT INTO book(isbn, title, subtitle, publishers, publish_date, number_of_pages) VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, book.getISBN(), book.getTitle(), book.getSubtitle(), book.getPublishers(), book.getPublicationDate(), book.getNumberOfPages());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, subtitle = ?, publishers = ?, publish_date = ?, number_of_pages = ? WHERE isbn = ?;";
        jdbcTemplate.update(sql, book.getTitle(), book.getSubtitle(), book.getPublishers(), book.getPublicationDate(), book.getNumberOfPages());
    }

    @Override
    public void deleteBook(String ISBN) {
        String sql = "DELETE FROM book_author WHERE isbn = ?;";
        jdbcTemplate.update(sql, ISBN);
        sql = "DELETE FROM book WHERE isbn = ?;";
        jdbcTemplate.update(sql, ISBN);
    }
}