package com.project.nasa.services;

import com.project.nasa.dtos.UserDetailsDTO;
import com.project.nasa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetailsDTO getUserDetailsById(Long id) {
        return null;
    }

    @Override
    public UserDetailsDTO updateUserDetails(Long id, UserDetailsDTO userDetailsDTO) {
        return null;
    }

    @Override
    public List<UserDetailsDTO> getAllUserDetails() {
        return null;
    }
}
