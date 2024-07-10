package com.example.Task1.Repository;

import com.example.Task1.dto.SongDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends MongoRepository<SongDTO, String> {
    @Query("{ 'artist' : ?0 }")
    List<SongDTO> findByArtist(String artist);
}
