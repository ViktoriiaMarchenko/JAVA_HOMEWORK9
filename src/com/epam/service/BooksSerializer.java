package com.epam.service;

import com.epam.model.Book;
import com.epam.model.Books;

import java.io.*;

public class BooksSerializer {
    private static final String FILE_NAME = "books.ser";
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public BooksSerializer() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBooks(Books books) {
        try {
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Books readBooks() {
        try {
            return (Books) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Data file not found, data is not readed");
        } catch (EOFException e) {
            System.out.println("File is empty, data is not readed");
        } catch (IOException e) {
            System.out.println("Read books error");
        }
        return new Books(new Book[0]);
    }

    public void saveBooks(Books books, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(books);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Books readBooks(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            return (Books) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new Books(new Book[0]);
        }
    }

    public void close() {
        try {
            objectOutputStream.close();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
