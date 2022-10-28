package com.homelibrary.aquisitions.services;

import com.homelibrary.aquisitions.model.Author;
import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Map;

public class BookService {

//    private static HttpURLConnection connection;
    public static String API_BASE_URL = "https://openlibrary.org/";
    private RestTemplate restTemplate = new RestTemplate();

    public Book getBook(String isbn) {
        Book book = null;
        try {
            book = restTemplate.getForObject(API_BASE_URL + "isbn/" + isbn + ".json", Book.class);
            Map authorsKeyList = book.getAuthors();
            for (Map.Entry<String, String> entry : authorsKeyList.entrySet())
            book.setAuthor(restTemplate.getForObject(API_BASE_URL + "authors/" + book.getAuthors() + ".json", Author.class));
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return book;
    }
}
