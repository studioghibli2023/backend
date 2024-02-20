package com.studio.service.impl;

import com.studio.common.UserRole;
import com.studio.domain.User;
import com.studio.dto.UserDTO;
import com.studio.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    void testGetUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(userService.getUsers());
    }

    @Test
    void testSave() {
        UserDTO userDTO = Mockito.mock(UserDTO.class);
        when(userDTO.getUserRole()).thenReturn(UserRole.CUSTOMER);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());
        Assert.assertNotNull(userService.saveUser(userDTO));
    }
}
