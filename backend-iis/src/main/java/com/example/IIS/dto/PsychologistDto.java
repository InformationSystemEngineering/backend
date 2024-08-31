package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PsychologistDto extends UserDTO{
    private Long id;
    private String name;
    private String lastName;
    private String biography;
    private String imageUrl;
    private boolean partOfCenter;

}
