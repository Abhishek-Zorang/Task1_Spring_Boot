package com.example.Task1.Controller;


import com.example.Task1.Service.SongService;
import com.example.Task1.Request_Body.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongService artist;

    @GetMapping("/song")
    public List<Song> getSongInfo(){
        return artist.getSong();
    }

    @GetMapping("/song/{id}")
    public Song getSongById(@PathVariable String id){
        return artist.getSongById(id);
    }

    @PostMapping("/song")
    public String postSongInfo(@RequestBody Song song_name){

        return artist.setSong(song_name);
    }

    @PutMapping("/song")
    public Song update(@RequestBody Song song_name){
        return artist.update(song_name.getId(),song_name);
    }

    @DeleteMapping("/song")
    public String delete(@RequestBody String k){
        return artist.delete(k);
    }

    @GetMapping("/song/query/{singer}")
    public List<Song> Query(@PathVariable String singer){
        return artist.findSong(singer);
    }
}
