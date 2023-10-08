package com.project.nasa.services;

import com.project.nasa.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserDetailsById(Long id);
    List<UserDTO> getAllUserDetails();
}
