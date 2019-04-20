package com.epam.controller;

import com.epam.exceptions.NotANumberException;
import com.epam.model.Book;
import com.epam.model.Books;
import com.epam.service.BooksSerializer;
import com.epam.view.ViewBooks;

import static com.epam.view.ViewBooks.*;


public class ControllerBooks {

    private Books books;
    private ViewBooks viewBooks;
    private BooksSerializer booksSerializer;

    public ControllerBooks(Books books, ViewBooks viewBooks) {
        this.books = books;
        this.viewBooks = viewBooks;
    }

    public ControllerBooks() {
        this.books = new Books(5);
        this.viewBooks = new ViewBooks();
        this.booksSerializer = new BooksSerializer();
    }

    public void run() {
        this.books = booksSerializer.readBooks();
        while(true) {
            System.out.println("1. Add books");
            System.out.println("2. Sort books by author");
            System.out.println("3. Change price");
            System.out.println("4. Find books by author");
            System.out.println("5. Find books by year");
            System.out.println("6. Save books");
            System.out.println("7. Read books");
            System.out.println("8. Exit");

            int choise = inputPositiveInt("$ ", "Incorrect input try again");
            switch(choise) {
                case 1:
                    int size = inputPositiveInt("Enter size bigger than 5: ", "Size is incorrect, try again");
                    books = new Books(size);  //create

                    books.addBook(new Book(121, "Zora Neale Hurston", "Their Eyes Were Watching God", "Harper Perennial Modern Classics", 2006, 219, 29.5));
                    books.addBook(new Book(122, "Sloane Crosley", "I Was Told There'd Be Cake", "Riverhead Books", 2008, 230, 15.6));
                    books.addBook(new Book(123, "Mark Haddon", "The Curious Incident of the Dog in the Night-Time", "Paperback", 2004, 226, 12.35));
                    books.addBook(new Book(124, "Stephen Chbosky", "The Perks of Being a Wallflower", "MTV Books/Pocket Books", 1999, 213, 19.65));
                    books.addBook(new Book(125, "Sloane Crosley", "I Was Told There'd Be Cake", "Riverhead Books", 2008, 230, 54.85));
                case 2:
                    Books sortedBooks = this.books.sortByAuthor();
                    viewBooks.printBooks(sortedBooks);
                    break;
                case 3:
                    int percent = inputPositiveInt(INPUT_PERCENT_INCREASE, "Percent is incorrect, try again");
                    this.books.changePrice(percent);
                    viewBooks.printBooks(this.books);
                    break;
                case 4:
                    viewBooks.printMessage(INPUT_AUTHOR);
                    InputUtil.inputString();
                    Books authorBooks = this.books.findBooksByAuthor(InputUtil.inputString());
                    viewBooks.printBooks(authorBooks);
                    break;
                case 5:
                    int year = inputPositiveInt(INPUT_YEAR, "Year is incorrect, try again");
                    Books yearBooks = this.books.findBooksAfterYear(year);
                    viewBooks.printBooks(yearBooks);
                    break;
                case 6:
                    String sFileName = InputUtil.inputString();
                    booksSerializer.saveBooks(this.books, sFileName);
                    System.out.println("Books are saved");
                    break;
                case 7:
                    String fileName = InputUtil.inputString();
                    booksSerializer.readBooks(fileName);
                    System.out.println("Books are readed");
                    break;
                case 8:
                    booksSerializer.saveBooks(this.books);
                    booksSerializer.close();
                    return;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    private int inputPositiveInt(String inputMessage, String errorMessage ) {
        int size = 0;
        String intStr;
        boolean wasInputError;
        do {
            try {
                wasInputError = false;
                viewBooks.printMessage(inputMessage);
                intStr = InputUtil.inputString();
                size = Validator.checkPositiveInt(intStr);
            } catch (NotANumberException e) {
                System.out.println(errorMessage + ": " + e.getMessage());
                wasInputError = true;
            }
        } while (wasInputError);
        return size;
    }
}

