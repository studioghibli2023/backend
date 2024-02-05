package com.studio.service.impl;

import com.studio.common.UserRole;
import com.studio.repository.UserRepository;
import com.studio.domain.User;
import com.studio.dto.UserDTO;
import com.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUser(final long userId) {
        User userDomain = userRepository.findById(userId);
        UserDTO user = new UserDTO();
        user.setId(userDomain.getId());
        user.setEmail(userDomain.getEmail());
        user.setName(userDomain.getName());
        user.setPassword(userDomain.getPassword());
        user.setUserRole(UserRole.getUserRole(userDomain.getRole()));
        return user;
    }

    @Override

    public void saveUser(UserDTO user) throws RuntimeException {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User already exists");
        }
        User userDomain = new User();
        userDomain.setName(user.getName());
        userDomain.setEmail(user.getEmail());
        userDomain.setPassword(user.getPassword());
        userDomain.setRole(user.getUserRole().getRoleNumber());
        userRepository.saveAndFlush(userDomain);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                        UserRole.getUserRole(user.getRole())))
                .collect(Collectors.toList());
    }
}
