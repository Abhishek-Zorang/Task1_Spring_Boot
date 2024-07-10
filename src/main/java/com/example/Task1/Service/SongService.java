package com.example.Task1.Service;

import com.example.Task1.Request_Body.Song;
import com.example.Task1.Repository.dao.SongDAO;
import com.example.Task1.dto.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@org.springframework.stereotype.Service
public class SongService {

    @Autowired
    private SongDAO songDAO;

    private SongDTO convertToEntity(Song songDTO) {
        return new SongDTO(songDTO.getId(), songDTO.getArtist(), songDTO.getSong_name(), songDTO.getLyrics());
    }

    private Song convertToDTO(SongDTO song) {
        return new Song(song.getId(), song.getArtist(), song.getSong_name(), song.getLyrics());
    }

    public List<Song> getSong(){
        //Song song = songDAO.findAll();
        return songDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Song getSongById(String id){
        SongDTO song = songDAO.findById(id);
        if(song!=null){
            return convertToDTO(song);
        }
        return null;
    }

//add response body
    public String setSong(Song song_name){
        SongDTO song = convertToEntity(song_name);
        songDAO.save(song);
        return "Song Added Successfully";
    }

    public Song update(String id, Song song_name){
        SongDTO song = songDAO.findById(id);
        if(song!=null){
            song.setSong_name(song_name.getSong_name());
            song.setLyrics(song_name.getLyrics());
            song.setArtist(song_name.getArtist());
            songDAO.save(song);
            return convertToDTO(song);
        }
        return null;

    }

    public String delete(String k){
        songDAO.deleteById(k);
        return "Deletion Success";
    }

    public List<Song> findSong(String singer){
        return songDAO.findSong(singer).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
