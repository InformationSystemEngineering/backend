package com.example.IIS.dto;

import com.example.IIS.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private String name;
    private String username;
    private String lastname;
    private String email;
    private String password;
    private boolean registerAsStudent;
    private boolean registerAsPsychologist;
    private boolean registerAsManager;
}