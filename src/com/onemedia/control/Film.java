package com.onemedia.control;

import java.time.LocalDate;

public class Film extends Product {

    public Film() {
        super();
        director = "";
        actor = "";
        genre = "";
        issuedDate = null;
    }
    public Film(String idCode, String name) {
        super(idCode, name);
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
        // TODO: Bổ sung in thông tin ra màn hình
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
