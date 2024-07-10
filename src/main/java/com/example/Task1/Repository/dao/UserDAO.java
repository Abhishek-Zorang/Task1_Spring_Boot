package com.example.Task1.Repository.dao;

import com.example.Task1.Repository.Userdetails;
import com.example.Task1.Request_Body.Song;
import com.example.Task1.Request_Body.User;
import com.example.Task1.dto.UserDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private Userdetails userdetails;

    public UserDTO getUserDetails(String name) {
        return userdetails.findByName(name);
    }

    public void createUser(UserDTO user) {
        userdetails.save(user);
    }

    public List<UserDTO> getAllUsers(){
        return userdetails.findAll();
    }

//    public List<Song> getFavSongs(String name){
//
//    }
}
