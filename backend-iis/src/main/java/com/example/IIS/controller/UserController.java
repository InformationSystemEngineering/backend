package com.example.IIS.controller;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.service.PostService;
import com.example.IIS.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable(name = "id") long id){

        UserDTO userResponse = userService.updateUser(userDTO, id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
