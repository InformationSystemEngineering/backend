package com.example.IIS.service;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByEmail(String email);

    UserDTO getById(long id);
    UserDTO updateUser(UserDTO userDTO, long id);
}
