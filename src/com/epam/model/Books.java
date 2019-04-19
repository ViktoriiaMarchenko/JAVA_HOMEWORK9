package com.epam.model;

import java.util.Arrays;
import java.util.Comparator;

public class Books {
    private int size; // virtual size
    private Book[] library;

    public Books(Book[] library) {
        this.library = library;
    }

    public Books(int size) {
        this.size = 0;
        library = new Book[size]; //       real size
    }

    public boolean addBook(Book book) {
        if (size >= library.length) {
            return false;
        }
        library[size++] = book;
        return true;
    }

    public Book[] getLibrary() {
        return library;
    }


    public void changePrice (int percent) {
        for (Book book : library) {
            if (book != null) {
                double percentPrice = (book.getPrice() / 100) * percent;
                double newPrice = book.getPrice() + percentPrice;
                book.setPrice(newPrice);
            }
        }
    }

    public Books findBooksByAuthor(String authorName) {
        // 1. Calc count of books with author
        int bookCountWithAuthor = 0;
        for (Book book: library) {
            if (book != null && authorName.equals(book.getAuthor())) {
                bookCountWithAuthor++;
            }
        }
        // 2. Create array with length
        Book[] result = new Book[bookCountWithAuthor];
        // 3. Fill the array with found books
        int bookIndex = 0;
        for (Book book: library) {
            if (book != null && authorName.equals(book.getAuthor())) {
                result[bookIndex++] = book;
            }
        }
        return new Books(result);
    }

    public Books findBooksAfterYear(int year) {
        int bookCountAfterYear = 0;
        for (Book book: library) {
            if (book != null && book.getYear() > year) {
                bookCountAfterYear++;
            }
        }
        Book[] result = new Book[bookCountAfterYear];

        int bookIndex = 0;
        for (Book book: library) {
            if (book != null && book.getYear() > year) {
                result[bookIndex++] = book;
            }
        }
        return new Books(result);
    }

    public Books sortByAuthor() {
        Book[] booksCopy = Arrays.copyOf(getLibrary(), getLibrary().length);
        Arrays.sort(booksCopy, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getAuthor().compareTo(book2.getAuthor());
            }
        });
        return new Books(booksCopy);
    }

    public Books sortByPublisher() {
        Book[] booksCopy = Arrays.copyOf(getLibrary(), getLibrary().length);
        Arrays.sort(booksCopy, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getPublisher().compareTo(book2.getPublisher());
            }
        });
        return new Books(booksCopy);
    }

    public Books sortByPrice() {
        Book[] booksCopy = Arrays.copyOf(getLibrary(), getLibrary().length);
        Arrays.sort(booksCopy, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return (int)(book1.getPrice() - book2.getPrice());
            }
        });
        return new Books(booksCopy);
    }

}
