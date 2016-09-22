package com.onemedia.control;

import java.util.Date;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Book extends Product {

    public Book(Tag tag, String name) {
        super(tag, name);
        type = ProductType.BOOK;
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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    private String author;
    private String genre;
    private String publisher;
    private Date timestamp;
}
