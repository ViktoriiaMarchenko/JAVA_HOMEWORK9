package com.epam.model;

public class Book {
    private int id;
    private String author;
    private String title;
    private String publisher;
    private int year;
    private int pageCount;
    private double price;

    public Book(int id, String author, String tittle, String publisher, int year, int pageCount, double price) {
        this.id = id;
        this.author = author;
        this.title = tittle;
        this.publisher = publisher;
        this.year = year;
        this.pageCount = pageCount;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }


    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor() {
        return this.author;
    }


    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }


    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher() {
        return this.publisher;
    }


    public void setYear(int year){
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }


    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }
    public int getPageCount() {
        return this.pageCount;
    }


    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", pageCount=" + pageCount +
                ", price=" + price +
                '}';
    }
}
