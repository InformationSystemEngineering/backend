package com.example.IIS.service.impl;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Role;
import com.example.IIS.domain.User;
import com.example.IIS.domain.enums.UserRole;
import com.example.IIS.dto.*;
import com.example.IIS.exception.IISException;
import com.example.IIS.repository.RoleRepo;
import com.example.IIS.repository.UserRepo;
import com.example.IIS.security.JwtTokenProvider;
import com.example.IIS.service.AuthService;
import com.example.IIS.service.RegisteredUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private PsychologistServiceImpl psychologistService;


    @Override
    public String login(LoginDTO loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));



        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    private RegisteredUserDto mapToDTO(RegisteredUser registeredUser){
        RegisteredUserDto registeredUserDto = mapper.map(registeredUser, RegisteredUserDto.class);
        return registeredUserDto;
    }

    private PsychologistDto mapToDTO(Psychologist psychologist){
        PsychologistDto psychologistDto = mapper.map(psychologist, PsychologistDto.class);
        return psychologistDto;
    }

    @Override
    public User register(RegisterDTO registerDto) {


        // add check for username exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new IISException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new IISException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

//        User user = new User();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setLastName(registerDto.getLastName());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));


        if (registerDto.isRegisterAsStudent()) {
            RegisteredUser registeredUser = new RegisteredUser();
            registeredUser.setStudent(true);
            registeredUser.setName(registerDto.getName());
            registeredUser.setUsername(registerDto.getUsername());
            registeredUser.setLastName(registerDto.getLastname());
            registeredUser.setEmail(registerDto.getEmail());
            registeredUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            RegisteredUserDto registeredUserDto = mapToDTO(registeredUser);
            registeredUserService.createReg(registeredUserDto);
        } else if (registerDto.isRegisterAsPsychologist()) {
            Psychologist psychologist = new Psychologist();

            psychologist.setRole(roleRepository.findByName("ROLE_PSYCHOLOG"));
            psychologist.setName(registerDto.getName());
            psychologist.setUsername(registerDto.getUsername());
            psychologist.setLastName(registerDto.getLastname());
            psychologist.setEmail(registerDto.getEmail());
            psychologist.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            PsychologistDto psychologistDto = mapToDTO(psychologist);
            psychologistService.createPsych(psychologistDto);
        } else if (registerDto.isRegisterAsManager()) {
            System.out.println("Setting role to MANAGER.");
//               user.setRole(roleRepository.findByName("ROLE_MANAGER"));
        } else {
            RegisteredUser registeredUser = new RegisteredUser();

            registeredUser.setRole(roleRepository.findByName("ROLE_REGISTERED_USER"));
            registeredUser.setStudent(false);
            registeredUser.setName(registerDto.getName());
            registeredUser.setUsername(registerDto.getUsername());
            registeredUser.setLastName(registerDto.getLastname());
            registeredUser.setEmail(registerDto.getEmail());
            registeredUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            RegisteredUserDto registeredUserDto = mapToDTO(registeredUser);
            registeredUserService.createReg(registeredUserDto);
        }


//        userRepository.save(user);

        return null;
    }
}