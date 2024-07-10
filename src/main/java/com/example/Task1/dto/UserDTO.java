package com.example.Task1.dto;

import com.example.Task1.Request_Body.Song;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Users")
public class UserDTO {
    //private String username;
    private String name;
    private String fav_singer;
    private List<String> fav_songs;

    public UserDTO(){}

    public UserDTO(String name, String fav_singer, List<String> fav_songs) {
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
