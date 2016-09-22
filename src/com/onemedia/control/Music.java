package com.onemedia.control;

import java.util.Date;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Music extends Product {

    public Music(Tag tag, String name) {
        super(tag, name);
        type = ProductType.MUSIC;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
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

    private String artist;
    private String genre;
    private Date timestamp;
}
