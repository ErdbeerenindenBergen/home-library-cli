package com.homelibrary.aquisitions.services;

import com.homelibrary.aquisitions.model.Author;
import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static String API_BASE_URL = "https://openlibrary.org/";
    private RestTemplate restTemplate = new RestTemplate();
    private List<Book> books;

    public Book getBook(String isbn) {
        Book book = null;
        Author author;

        try {
            book = restTemplate.getForObject(API_BASE_URL + "isbn/" + isbn + ".json", Book.class);
            if (book == null) {
                System.out.println("This book could not be found.");
            } else {
                List<Object> authorKeysList = book.getAuthors();
                List<Author> allAuthors = new ArrayList<>();
                for (Object authorOfBook : authorKeysList) {
                    String authorString = authorOfBook.toString();
                    String additionToBaseAuthorURL = authorString.substring(5, authorString.length() - 1);
                    author = restTemplate.getForObject(API_BASE_URL + additionToBaseAuthorURL + ".json", Author.class);
                    allAuthors.add(author);
                }
                book.setAllAuthors(allAuthors);
//            shelf.add(book);
            }
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return book;
    }
}
