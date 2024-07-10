package com.example.Task1.Controller;

import com.example.Task1.Request_Body.Song;
import com.example.Task1.Request_Body.User;
import com.example.Task1.Response.FavSingerResponse;
import com.example.Task1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
     private UserService userService;

    @GetMapping("/user")
    public String welcome(){
        return "Hello";
    }
    @PostMapping("/user/info")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("user/info")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/fav_singer/{id}")
    public FavSingerResponse getSongInfo(@PathVariable String id){
        return userService.getFavSinger(id);
    }

    @GetMapping("/user/fav_song/{id}")
    public List<Song> getFavSong(@PathVariable String id){
        return userService.getFavSongs(id);
    }
}
