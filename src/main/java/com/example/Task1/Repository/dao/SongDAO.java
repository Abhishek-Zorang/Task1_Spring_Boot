package com.example.Task1.Repository.dao;

import com.example.Task1.dto.SongDTO;
import com.example.Task1.Repository.AlbumRepo;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SongDAO {

    @Autowired
    private AlbumRepo album;

    public List<SongDTO> findAll(){
        return album.findAll();
    }

    public SongDTO findById(String id) {
        return album.findById(id).orElse(null);
    }

    public SongDTO save(SongDTO song){
        return album.save(song);
    }

    public void deleteById(String id) {
        album.deleteById(id);
    }

    public List<SongDTO> findSong(String singer){

        return album.findByArtist(singer);

    }
}
