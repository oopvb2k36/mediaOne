package com.onemedia.control;

import java.time.LocalDate;

public class Music extends Product {

    public Music() {
        super();
        artist = "";
        genre = "";
        issuedDate = null;
    }

    public Music(String idCode, String name) {
        super(idCode, name);
        artist = "";
        genre = "";
        issuedDate = null;
    }

    public Music(Product product) {
        super(product);
    }
    public Music(Music music) {
        super(music);
        setArtist(music.getArtist());
        setGenre(music.getGenre());
        setIssuedDate(music.getIssuedDate());
    }

    @Override
    public void printInfo() {
        System.out.format("Ma bai hat: %s, Ten bai hat: %s, Nghe sy: %s, The loai: %s, Ngay phat hanh: %s\n",
                getIdCode() , getName(), artist, genre, issuedDate);
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

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    private String artist;
    private String genre;
    private LocalDate issuedDate;
}
