package com.homelibrary.aquisitions;

import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.aquisitions.services.BookService;
import com.homelibrary.aquisitions.services.ConsoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeLibraryApplication {

    private final ConsoleService consoleService = new ConsoleService();
    private final BookService bookService = new BookService();

    public static void main(String[] args) {
        HomeLibraryApplication app = new HomeLibraryApplication();
        app.run();
//        SpringApplication.run(HomeLibraryApplication.class, args);
    }
    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                handleFindBookByISBN();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

    private void printBookOrError(Book book) {
        if (book != null) {
            consoleService.printBook(book);
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleFindBookByISBN() {
        String isbn = consoleService.promptForBookISBN();
        if (isbn != null) {
            Book book = bookService.getBook(isbn);
            printBookOrError(book);
        }
    }

}
