package com.project.nasa.services;

import com.project.nasa.dtos.UserDTO;
import com.project.nasa.dtos.UserDetailsDTO;
import com.project.nasa.models.Project;
import com.project.nasa.models.User;
import com.project.nasa.repository.UserRepository;
import com.project.nasa.utils.ServiceMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public UserDTO getUserDetailsById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return serviceMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUserDetails() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> serviceMapper.mapToUserDTO(user))
                .collect(Collectors.toList());
    }
}
