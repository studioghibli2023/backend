package com.studio.service.impl;

import com.studio.common.UserRole;
import com.studio.domain.Course;
import com.studio.domain.User;
import com.studio.dto.CourseDTO;
import com.studio.dto.UserDTO;
import com.studio.repository.CourseRepository;
import com.studio.repository.UserRepository;
import com.studio.service.UserService;
import com.studio.util.DataTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public UserDTO getUser(final long userId) {
        User userDomain = userRepository.findById(userId).get();
        UserDTO user = new UserDTO();
        user.setId(userDomain.getId());
        user.setEmail(userDomain.getEmail());
        user.setName(userDomain.getName());
        user.setPassword(userDomain.getPassword());
        user.setUserRole(UserRole.getUserRole(userDomain.getRole()));
        Course course = userDomain.getCourse();
        CourseDTO courseDTO = DataTransferUtil.getCourseDTO(course);
        user.setCourse(courseDTO);
        return user;
    }


    @Override

    public User saveUser(UserDTO user) throws RuntimeException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        User userDomain = new User();
        userDomain.setName(user.getName());
        userDomain.setEmail(user.getEmail());
        userDomain.setPassword(user.getPassword());
        userDomain.setRole(user.getUserRole().getRoleNumber());
        return userRepository.save(userDomain);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                        UserRole.getUserRole(user.getRole()), DataTransferUtil.getCourseDTO(user.getCourse())))
                .toList();
    }

    public void updateUser(final long userId, final long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            userRepository
                    .findById(userId)
                    .ifPresent(user -> {
                        user.setCourse(course.get());
                        userRepository.save(user);
                    });
        }
    }
}
