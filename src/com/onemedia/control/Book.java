package com.onemedia.control;

import java.time.LocalDate;

public class Book extends Product {

    public Book() {
        super();
    }

    public Book(String idCode, String name) {
        super(idCode, name);
    }

    public Book(Book book) {
        super(book);
        setAuthor(book.getAuthor());
        setGenre(book.getGenre());
        setPublisher(book.getPublisher());
        setIssuedDate(book.getIssuedDate());
    }

    @Override
    public void printInfo() {
        // TODO: Bổ sung in thông tin ra màn hình
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    private String author;
    private String genre;
    private String publisher;
    private LocalDate issuedDate;
}
