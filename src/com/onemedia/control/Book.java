package com.onemedia.control;

import java.time.LocalDate;

public class Book extends Product {

    public Book() {
        super();
        author = "NO AUTHOR";
        genre = "NO GENRE";
        publisher = "NO PUBLISHER";
        issuedDate = null;
    }

    public Book(String idCode, String name) {
        super(idCode, name);
        author = "NO AUTHOR";
        genre = "NO GENRE";
        publisher = "NO PUBLISHER";
        issuedDate = null;
    }

    public Book(Product product){
        super(product);
        author = "NO AUTHOR";
        genre = "NO GENRE";
        publisher = "NO PUBLISHER";
        issuedDate = null;
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
        super.printInfo();
        System.out.format("Tac gia: %s, Nha xuat ban: %s, Ngay san xuat: %s\n",
               author, publisher, issuedDate);
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
