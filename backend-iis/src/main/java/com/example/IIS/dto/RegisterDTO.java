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
    private String email;
    private String password;
<<<<<<< HEAD

=======
    private UserRole role;
>>>>>>> 45917f07e30360bb7d28def0bbb1c13566cc52df
}
