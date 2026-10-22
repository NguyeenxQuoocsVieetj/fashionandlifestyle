package org.example.fashionandlifestyle.service;

import org.example.fashionandlifestyle.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(Long id);
    UserDTO login(String email, String passWord);
}
