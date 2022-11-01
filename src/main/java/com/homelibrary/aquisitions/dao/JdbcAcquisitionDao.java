package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcAcquisitionDao extends AcquisitionDao {

    JdbcTemplate jdbcTemplate;

    public JdbcAcquisitionDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate();}

    @Override
    public List<Book> findAll() {
        List<Book> books = null;
        String sql = "SELECT ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            books.add(mapRowToAcquisition(results));
        }
        return books;
    }

    @Override
    private Book mapRowToAcquisition(SqlRowSet rowSet) {
        Book book = new Book();
        book.setISBN(String.valueOf(rowSet.getInt("isbn")));
        book.setTitle(rowSet.getString("title"));
        book.setSubtitle(rowSet.getString("subtitle"));
        book.setNumberOfPages(rowSet.getInt("number_of_pages"));
        book.setPublishers(rowSet.getString("publishers"));
        return book;
    }
}
