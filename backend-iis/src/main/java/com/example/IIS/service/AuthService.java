package com.example.IIS.service;

import com.example.IIS.dto.LoginDTO;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.exception.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    String login(LoginDTO loginDto);

    ResponseEntity<ApiResponse> register(RegisterDTO registerDto);
}
