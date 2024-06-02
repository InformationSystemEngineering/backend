package com.example.IIS.service.impl;

import com.example.IIS.domain.Post;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.StudentExtraActivity;
import com.example.IIS.domain.User;
import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.StudentExtraActivityDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.repository.PostRepository;
import com.example.IIS.repository.UserRepository;
import com.example.IIS.service.StudentExtraActivityService;
import com.example.IIS.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StudentExtraActivityService studentExtraActivityService;

    @Override
    public UserDTO getUserByEmail(String email) {
        long id = userRepository.findByEmail(email).getId();
        User user = userRepository.findById(id).get();
        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        // get post by id from the database
        User user = userRepository.findById(id).get();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }

    private UserDTO mapToDTO(User user){
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsersByExtraActivityId(long id) {
        List<UserDTO> users = new ArrayList<>();
        List<StudentExtraActivityDto> list = studentExtraActivityService.getAll();

        for (StudentExtraActivityDto studentExtraActivity : list) {
            if (studentExtraActivity.getExtraActivityId().equals(id)) {
                UserDTO userDto = getById(studentExtraActivity.getUserId());
                users.add(userDto);
            }
        }

        return users;
    }

    @Override
    public UserDTO getById(long id) {
        User user = userRepository.findById(id).get();
        return mapToDTO(user);
    }
}
