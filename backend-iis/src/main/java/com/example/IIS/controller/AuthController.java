package com.example.IIS.controller;

import com.example.IIS.domain.User;
import com.example.IIS.dto.JWTAuthResponse;
import com.example.IIS.dto.LoginDTO;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDto){

        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        System.out.println("Generisani JWT token: " + token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDto){
        User response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}