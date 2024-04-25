package com.example.IIS.service;

import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface RegisteredUserService {
    RegisteredUserDto createReg(RegisteredUserDto registerDTO);

    List<RegisteredUserDto> getAllUsers();

    RegisteredUserDto getById(long id);
}
