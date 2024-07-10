package com.example.Task1.Repository;

import com.example.Task1.dto.SongDTO;
import com.example.Task1.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Userdetails extends MongoRepository<UserDTO,String> {
    UserDTO findByName(String name);
}
