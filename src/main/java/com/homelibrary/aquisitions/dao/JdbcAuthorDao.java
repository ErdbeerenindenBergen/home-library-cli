package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAuthorDao implements AuthorDao {

    JdbcTemplate jdbcTemplate;

    public JdbcAuthorDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public Author getAuthor(String authorId) {
        Author author = null;
        String sql = "SELECT author_id, name\n" +
                "\tFROM author " +
                "WHERE author_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, authorId);
        if (results.next()) {
            author = mapRowToAuthor(results);
        }
        return author;
    }

    @Override
    public List<Author> getAuthorsByBook(int ISBN) {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT author.name FROM author JOIN book_author ON author.author_id = book_author.author_id WHERE isbn = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ISBN);
        while (results.next()) {
            authors.add(mapRowToAuthor(results));
        }
        return authors;
    }

    @Override
    public void createAuthor(Author author) {
        String sql = "INSERT INTO author(author_id, name) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, author.getAuthorId(), author.getName());
    }

    @Override
    public void updateAuthor(Author author) {
        String sql = "UPDATE author " +
                "SET name = ?, author_id = ?;";
        jdbcTemplate.update(sql, author.getName(), author.getAuthorId());
    }

    @Override
    public void deleteAuthor(int authorId) {
        String sql = "DELETE FROM book_author WHERE author_id = ?;";
        jdbcTemplate.update(sql, authorId);
        sql = "DELETE FROM author WHERE author_id = ?;";
        jdbcTemplate.update(sql, authorId);
    }

    @Override
    public void addAuthorToBook(String ISBN, int authorId) {
        String sql = "INSERT INTO public.book_author(\n" +
                "\tisbn, author_id)\n" +
                "\tVALUES (?, ?);";
        jdbcTemplate.update(sql, ISBN, authorId);
    }

    @Override
    public void removeAuthorFromBook(String ISBN, int authorId) {
        String sql = "DELETE FROM book_author WHERE isbn = ? AND author_id = ?;";
        jdbcTemplate.update(sql, ISBN, authorId);
    }

    private Author mapRowToAuthor(SqlRowSet rowSet) {
        Author author = new Author();
        author.setKey(rowSet.getString("author_id"));
        author.setName(rowSet.getString("name"));
        return author;
    }
}
