package com.example.Task1.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Songs")
public class SongDTO {
    private String id;
    private String artist;
    private String song_name;
    private String lyrics;

    public SongDTO(String id, String artist, String song_name, String lyrics) {
        this.id = id;
        this.artist = artist;
        this.song_name = song_name;
        this.lyrics = lyrics;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
