package com.homelibrary.aquisitions.services;

import com.homelibrary.aquisitions.model.Book;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Online Books Menu----");
            System.out.println("1: Enter ISBN to search for book");
//        System.out.println("1: List all books");
//        System.out.println("2: List details for specific book");
//        System.out.println("3: Find books by ISBN");
//        System.out.println("4: Find books by title");
//        System.out.println("5: Create a new book");
//        System.out.println("6: Modify a book");
//        System.out.println("7: Delete a book");
//        System.out.println("0: Exit");
        System.out.println();
    }

    public void printBookMenu(Book[] books) {
        printBooks(books);
        System.out.println("0: Exit");
        System.out.println();
    }

    public String promptForBookISBN() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter ISBN to search for: ");
        return scanner.nextLine();
    }

//    public String promptForBookTitle() {
//        System.out.println("--------------------------------------------");
//        System.out.print("Enter title to search for: ");
//        return scanner.nextLine();
//    }

    public void printBooks(Book[] books) {
        if (books != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Auctions");
            System.out.println("--------------------------------------------");
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void printBook(Book book) {
        System.out.println("--------------------------------------------");
        System.out.println("Book Details");
        System.out.println("--------------------------------------------");
        if (book == null) {
            System.out.println("No book has been found.");
        } else {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Subtitle: " + book.getSubtitle());
            System.out.println("Author(s): " + book.getAuthor());
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}







