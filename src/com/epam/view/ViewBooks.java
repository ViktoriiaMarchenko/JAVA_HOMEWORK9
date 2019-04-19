package com.epam.view;

import com.epam.model.Book;
import com.epam.model.Books;

public class ViewBooks {
    public static final String INPUT_YEAR = "\nInput issue year: ";
    public static final String INPUT_PERCENT_INCREASE = "\nEnter percent increase: ";
    public static final String INPUT_AUTHOR = "\nInput author: ";
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printBooks(Books books) {
        Book[] library = books.getLibrary();
        for (Book book: library) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }
}



