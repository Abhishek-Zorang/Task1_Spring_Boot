package com.example.Task1.Request_Body;

import java.util.List;

public class User {
    private String name;
    private String fav_singer;
    private List<String> fav_songs;

    public User(){}

    public User(String name, String fav_singer, List<String> fav_songs) {
        this.name = name;
        this.fav_singer = fav_singer;
        this.fav_songs = fav_songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFav_singer() {
        return fav_singer;
    }

    public void setFav_singer(String fav_singer) {
        this.fav_singer = fav_singer;
    }

    public List<String> getFav_songs() {
        return fav_songs;
    }

    public void setFav_songs(List<String> fav_songs) {
        this.fav_songs = fav_songs;
    }
}
