package com.onemedia.control;

import java.util.Date;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Film extends Product {

    public Film(Tag tag, String name) {
        super(tag, name);
        type = ProductType.FILM;
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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }


    private String director;
    private String actor;
    private String genre;
    private Date timestamp;
}
