package com.homelibrary.aquisitions;

import com.homelibrary.aquisitions.dao.BookDao;
import com.homelibrary.aquisitions.dao.JdbcBookDao;
import com.homelibrary.aquisitions.dao.AuthorDao;
import com.homelibrary.aquisitions.dao.JdbcAuthorDao;
import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.aquisitions.model.Shelf;
import com.homelibrary.aquisitions.model.Author;
import com.homelibrary.aquisitions.services.BookService;
import com.homelibrary.aquisitions.services.ConsoleService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.awt.*;
import java.util.List;

@SpringBootApplication
public class HomeLibraryApplication {

    private final ConsoleService consoleService = new ConsoleService();
    private final BookService bookService = new BookService();
    private final Shelf bookShelf = new Shelf();
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/HomeLibraryDB");
        dataSource.setUsername("postgres");

        HomeLibraryApplication app = new HomeLibraryApplication(dataSource);
        app.run();
    }

    public HomeLibraryApplication(DataSource dataSource) {
        authorDao = new JdbcAuthorDao(dataSource);
        bookDao = new JdbcBookDao(dataSource);
    }

    private void run() {

        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                Book book = handleFindBookByISBN();
                handleAddBookToShelf(book);
            } else if (menuSelection == 2) {
                handlePrintingAllBooksOnBookShelf();
            } else if (menuSelection == 3) {
                handleRemovingBookFromBookShelf();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void printBookOrError(Book book) {
        if (book != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Book Information");
            System.out.println("--------------------------------------------");
            consoleService.printBook(book);
        } else {
            consoleService.printErrorMessage();
        }
    }

    private List<Book> handleAddBookToShelf(Book book) {
        boolean isBookAdded = consoleService.askUserWhetherToAddBookToShelf();
        bookShelf.addBookToShelf(isBookAdded, book);
        return bookShelf.getBooks();
        }

    private void handlePrintingAllBooksOnBookShelf() {
        if (bookShelf.getBooks().isEmpty()) {
            System.out.println("You have no books on your bookshelf.");
        } else {
            consoleService.printAllBooksOnShelf(bookShelf.getBooks());
        } consoleService.pause();
    }

    private Book handleFindBookByISBN() {
        String isbn = consoleService.promptForBookISBN();
        Book book = null;
        if (isbn != null) {
            book = bookService.getBook(isbn);
            printBookOrError(book);
        }
        return book;
    }

    private void handleRemovingBookFromBookShelf() {
        consoleService.printTitlesAndOrderOfBooksOnShelf(bookShelf.getBooks());
        int bookToRemove = consoleService.promptForBookToRemove();
        bookShelf.removeBookFromShelf(bookToRemove);
    }
}

//    private void handleAddBookByISBN() {
//        String isbn = consoleService.promptForBookISBN();
//        if (isbn != null) {
//            Book book = bookService.getBook(isbn);
//            bookService.addBookToShelf(book);
//            List<Book> shelf = bookService.getShelf();
//            System.out.println();
//        }
//    }

//        SpringApplication.run(HomeLibraryApplication.class, args);
