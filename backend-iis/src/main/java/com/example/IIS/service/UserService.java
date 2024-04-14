package com.example.IIS.service;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.UserDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);

    UserDTO updateUser(UserDTO userDTO, long id);
}
