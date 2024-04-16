package com.studio.service;

import com.studio.domain.User;
import com.studio.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(final long userId);

    List<UserDTO> getUsers();

    UserDTO saveUser(final UserDTO user) throws RuntimeException;
    UserDTO saveUser(final UserDTO user, final Long courseId) throws RuntimeException;

    void updateUser(final long userId, final long courseId);

    UserDTO userLogin(final String email, final String password);

    UserDTO getUserByEmail(final String email);
}
