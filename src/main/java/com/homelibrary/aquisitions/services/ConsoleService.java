package com.homelibrary.aquisitions.services;

import com.homelibrary.aquisitions.HomeLibraryApplication;
import com.homelibrary.aquisitions.model.Book;
import com.homelibrary.aquisitions.model.Shelf;

import java.util.List;
import java.util.Objects;
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

    //Select * from vw_get_all_reservations

        public boolean askUserWhetherToAddBook() {
        String addBookAnswer;
        boolean bookIsAddedToShelf = false;
        System.out.println("Would you like to add this book to your shelf? Enter Y for yes or N for no.");
        addBookAnswer = scanner.nextLine();
        if (Objects.equals(addBookAnswer, "Y")) {
            bookIsAddedToShelf = true;
        } else if (Objects.equals(addBookAnswer, "N")) {
            System.out.println("You have elected not to add the book to your bookshelf.");
        } else {
            System.out.print("You have not entered a valid answer. ");
        }
        return bookIsAddedToShelf;
    }


    public void printMainMenu() {
        System.out.println("                         ");
        System.out.println("----Online Books Menu----");
        System.out.println("1: Search for a book by its ISBN");
        System.out.println("2: See all books currently on your bookshelf");
        System.out.println("3: Remove a book from your bookshelf");
//        System.out.println("1: List all books");
//        System.out.println("2: List details for specific book");
//        System.out.println("3: Find books by ISBN");
//        System.out.println("4: Find books by title");
//        System.out.println("5: Create a new book");
//        System.out.println("6: Modify a book");
//        System.out.println("7: Delete a book");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printAddBookMenu() {
        System.out.println("                         ");
        System.out.println("Please select from the following options:");
        System.out.println("1: Add this book to your bookshelf.");
        System.out.println("2: Add this book to your home library.");
        System.out.println("3: Return to Main Menu.");
    }

    public void printBookMenu(Book[] books) {
        printBooks(books);
        System.out.println("0: Exit");
        System.out.println();
    }

    public String promptForBookISBN() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter ISBN you would like to search: ");
        return scanner.nextLine();
    }

    public int promptForBookToRemove() {
        int bookToRemove;
        System.out.println("--------------------------------------------");
        System.out.print("Enter the number of the book you would you like to delete: ");
        try {
            bookToRemove = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            bookToRemove = -1;
        }
        return bookToRemove;
    }

    public void printBooks(Book[] books) {
        if (books != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Books");
            System.out.println("--------------------------------------------");
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void printTitlesAndOrderOfBooksOnShelf(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("--------------------------------------------");
            System.out.println("Book " + (i+1));
            System.out.println("Title: " + books.get(i).getTitle());
        }
    }

    public void printBook(Book book) {
        //prints title, subtitle (if not null), and author of book after querying two APIs
        if (book == null) {
            System.out.println("No book has been found.");
        } else {
            System.out.println("Title: " + book.getTitle());
            if (book.getSubtitle() != null) {
                System.out.println("Subtitle: " + book.getSubtitle());
            }
            System.out.print("Author(s): ");
            for (int i = 0; i < book.getAllAuthors().size(); i++)
                if (i == (book.getAllAuthors().size() - 1)) {
                    System.out.print(book.getAllAuthors().get(i).getName());
                } else {
                    System.out.print(book.getAllAuthors().get(i).getName() + ", ");
                }
            System.out.println(" ");
            System.out.println("Publisher: " + book.getPublishers());
            System.out.println("Number of Pages: " + book.getNumberOfPages());
            System.out.println("Publication Date: " + book.getPublicationDate());
//          System.out.println("First Sentence: " + book.getFirstSentence().get(1).toString());
            System.out.println("--------------------------------------------");
            System.out.println(" ");
        }
    }

    public void printAllBooksOnShelf(List<Book> books) {
        for (Book book : books) {
            System.out.println("--------------------------------------------");
            System.out.println("Book Information");
            System.out.println("--------------------------------------------");
            printBook(book);
        }
    }

//    public void pause() {
//        System.out.println("\nPress Enter to continue...");
//        scanner.nextLine();
//    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }
}

//    public void addBookToShelf(String answer, Book book) {
//        if (answer.equalsIgnoreCase("Y")) {
//            shelf.getBooks().add(book);
//            System.out.println("Your book, " + book.getTitle() + " has been added to the shelf.");
//        } else if (answer.equalsIgnoreCase("N")) {
//            System.out.println("You have elected not to add " + book.getTitle() + " to your bookshelf.");
//        } else {
//            System.out.println("You have not entered a valid answer. Please enter Y for yes or N for no.");
//            HomeLibraryApplication.handleAddBookToShelf();
//        }
//    }

//    public String promptForBookTitle() {
//        System.out.println("--------------------------------------------");
//        System.out.print("Enter title to search for: ");
//        return scanner.nextLine();
//    }

//    public List<Book> askUserWhetherToAddBookToShelf(Book book) {
//        String addBookAnswer;
//        System.out.println("Would you like to add this book to your shelf? Enter Y for yes or N for no.");
//        addBookAnswer = scanner.nextLine();
//        if (addBookAnswer == "Y" || addBookAnswer == "y") {
//            shelf.getBooks().add(book);
//        } else if (addBookAnswer.equalsIgnoreCase("N")) {
//            System.out.println("");
//        } else {
//            System.out.println("You have not entered a valid answer. Please enter Y for yes or N for no.");
//            askUserWhetherToAddBookToShelf(book);
//        }
//        return shelf.getBooks();
//    }

//Tester ISBNs:
//9780631188919
//9780804736336








