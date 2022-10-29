package com.homelibrary.aquisitions;

import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.aquisitions.model.Shelf;
import com.homelibrary.aquisitions.services.BookService;
import com.homelibrary.aquisitions.services.ConsoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HomeLibraryApplication {

    private final ConsoleService consoleService = new ConsoleService();
    private final BookService bookService = new BookService();
    private final Shelf bookShelf = new Shelf();

    public static void main(String[] args) {
        HomeLibraryApplication app = new HomeLibraryApplication();
        app.run();
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
        }
//        if (bookShelf.getBooks() != null) {
//            consoleService.printAllBooksOnShelf(bookShelf.getBooks());
//        } else {
//            System.out.println("You have no books on your bookshelf.");
//        }
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
