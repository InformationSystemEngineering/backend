package com.example.IIS.service;

import com.example.IIS.dto.LoginDTO;
import com.example.IIS.dto.RegisterDTO;

public interface AuthService {
    String login(LoginDTO loginDto);

    String register(RegisterDTO registerDto);
}
