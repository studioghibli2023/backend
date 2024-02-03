package com.studio.service.impl;

import com.studio.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    public UserServiceImpl userService;

    @Test
    public void testGetUsers() {
        UserRepository localMockRepository = Mockito.mock(UserRepository.class);
        when(localMockRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(userService.getUsers());
    }
}
