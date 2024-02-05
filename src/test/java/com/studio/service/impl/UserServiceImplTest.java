package com.studio.service.impl;

import com.studio.common.UserRole;
import com.studio.domain.User;
import com.studio.dto.UserDTO;
import com.studio.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;

import static org.mockito.Mockito.when;



@SpringBootTest
@ActiveProfiles("test")
public class UserServiceImplTest {

    @Autowired
    public UserServiceImpl userService;

    @Test
    public void testGetUsers() {
        UserRepository localMockRepository = Mockito.mock(UserRepository.class);
        when(localMockRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(userService.getUsers());
    }
    @Test
    public void testSave() {
        UserRepository localMockRepository = Mockito.mock(UserRepository.class);
        UserDTO userDTO = Mockito.mock(UserDTO.class);
        when(userDTO.getUserRole()).thenReturn(UserRole.CUSTOMER);
        when(localMockRepository.save(Mockito.any(User.class))).thenReturn(new User());
        Assert.assertNotNull(userService.saveUser(userDTO));
    }
}
