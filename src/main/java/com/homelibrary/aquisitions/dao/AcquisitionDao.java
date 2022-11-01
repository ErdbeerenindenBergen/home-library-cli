package com.homelibrary.aquisitions.dao;

import com.homelibrary.aquisitions.model.Book;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class AcquisitionDao {

    public List<Book> findAll() {
        return null;
    }

    private Book mapRowToAcquisition(SqlRowSet rowSet) {return null;}
}
