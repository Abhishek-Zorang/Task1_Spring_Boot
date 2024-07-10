package com.example.Task1.Response;

import com.example.Task1.Request_Body.Song;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FavSingerResponse {

    @JsonProperty
    private String fav_singer;

    @JsonProperty
    private List<Song> artist_Songs;

    public String getFav_singer() {
        return fav_singer;
    }

    public void setFav_singer(String fav_singer) {
        this.fav_singer = fav_singer;
    }

    public List<Song> getArtist_Songs() {
        return artist_Songs;
    }

    public void setArtist_Songs(List<Song> artist_Songs) {
        this.artist_Songs = artist_Songs;
    }
//
//    public FavSingerResponse(String fav_singer, List<Song> artist_Songs) {
//        this.fav_singer = fav_singer;
//        this.artist_Songs =  artist_Songs;
//    }
}
