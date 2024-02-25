package com.studio.service;

import com.studio.domain.User;
import com.studio.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(final long userId);

    List<UserDTO> getUsers();

    User saveUser(UserDTO user) throws RuntimeException;

    void updateUser(final long userId, final long courseId);

    UserDTO userLogin(final String email, final String password);
}
