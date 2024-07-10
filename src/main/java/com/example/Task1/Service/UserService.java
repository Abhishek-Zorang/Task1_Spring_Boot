package com.example.Task1.Service;

import com.example.Task1.Repository.dao.SongDAO;
import com.example.Task1.Repository.dao.UserDAO;
import com.example.Task1.Request_Body.Song;
import com.example.Task1.Request_Body.User;
import com.example.Task1.Response.FavSingerResponse;
import com.example.Task1.dto.SongDTO;
import com.example.Task1.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SongDAO songDAO;

    private User convertuser(UserDTO user){
        return new User(user.getName(), user.getFav_singer(), user.getFav_songs());
    }

    private UserDTO convertToUserDTO(User user){
        return new UserDTO(user.getName(), user.getFav_singer(), user.getFav_songs());
    }

    private Song convertToDTO(SongDTO song) {
        return new Song(song.getId(), song.getArtist(), song.getSong_name(), song.getLyrics());
    }

    public FavSingerResponse getFavSinger(String name){
        FavSingerResponse response = new FavSingerResponse();
        String fav_singer = userDAO.getUserDetails(name).getFav_singer();
        response.setFav_singer(fav_singer);
        response.setArtist_Songs(songDAO.findSong(fav_singer)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()));

        return response;
    }

    public Song ConvertToSong_id(String id){
        return convertToDTO(songDAO.findById(id));
    }
    public List<Song> createList(List<String> fav_song_ids){
        return fav_song_ids.stream()
                .map(this::ConvertToSong_id)
                .collect(Collectors.toList());
    }


    public List<Song> getFavSongs(String name){
        return createList(userDAO.getUserDetails(name).getFav_songs());//list of song id
    }

    public void createUser(User user) {
        userDAO.createUser( convertToUserDTO(user));
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers().stream().map(this::convertuser).collect(Collectors.toList());
    }
}
