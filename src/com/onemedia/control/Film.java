package com.onemedia.control;

import java.time.LocalDate;

public class Film extends Product {

    public Film() {
        super();
        director = "NO DIRECTOR";
        actor = "NO ACTOR";
        genre = "NO GENRE";
        issuedDate = null;
    }
    public Film(String idCode, String name) {
        super(idCode, name);
        director = "NO DIRECTOR";
        actor = "NO ACTOR";
        genre = "NO GENRE";
        issuedDate = null;
    }

    public Film(Product product) {
        super(product);
        director = "NO DIRECTOR";
        actor = "NO ACTOR";
        genre = "NO GENRE";
        issuedDate = null;
    }
    public Film(Film film) {
        super(film);
        setDirector(film.getDirector());
        setActor(film.getActor());
        setGenre(film.getGenre());
        setIssuedDate(film.getIssuedDate());
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.format("Dao dien: %s, Nhan vat chinh: %s, The loai: %s," +
                        " Ngay san xuat: %s\n",
                director, actor, genre, issuedDate);
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    private String director;
    private String actor;
    private String genre;
    private LocalDate issuedDate;
}
