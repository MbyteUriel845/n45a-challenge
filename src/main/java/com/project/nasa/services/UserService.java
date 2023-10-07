package com.project.nasa.services;

import com.project.nasa.dtos.UserDetailsDTO;

import java.util.List;

public interface UserService {

//    UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO getUserDetailsById(Long id);
    UserDetailsDTO updateUserDetails(Long id, UserDetailsDTO userDetailsDTO);

//    void deleteUserDetails(Long id);
    List<UserDetailsDTO> getAllUserDetails();
}
