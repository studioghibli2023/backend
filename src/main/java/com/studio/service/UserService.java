package com.studio.service;

import com.studio.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(final long userId);

    List<UserDTO> getUsers();

    void saveUser(UserDTO user) throws RuntimeException;
}
