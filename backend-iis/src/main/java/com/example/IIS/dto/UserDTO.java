package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
}
