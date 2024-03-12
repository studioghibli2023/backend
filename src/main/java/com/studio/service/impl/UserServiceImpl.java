package com.studio.service.impl;

import com.studio.common.UserRole;
import com.studio.domain.Course;
import com.studio.domain.User;
import com.studio.dto.UserDTO;
import com.studio.repository.CourseRepository;
import com.studio.repository.UserRepository;
import com.studio.service.UserService;
import com.studio.util.DataTransferUtil;
import org.apache.commons.lang3.StringUtils;
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
         if(userRepository.findById(userId).isPresent()){
             return DataTransferUtil.getUserDTO(userRepository.findById(userId).get());
         }else{
             throw new RuntimeException("User not found.");
         }
    }
    @Override
    public UserDTO getUserByEmail(final String email) {
         User user = userRepository.findByEmail(email);
         if(user != null){
            return DataTransferUtil.getUserDTO(user);
        }else{
            throw new RuntimeException("User not found.");
        }
    }
    @Override

    public User saveUser(final UserDTO user) throws RuntimeException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(DataTransferUtil.getUserDomain(user));
    }
    public User saveUser(UserDTO userDto, final Long courseId) throws RuntimeException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        if(courseId != null){
            Optional<Course> course = courseRepository.findById(courseId);
            if(course.isPresent()) {
              User user = DataTransferUtil.getUserDomain(userDto);
              user.setCourse(course.get());
              return userRepository.save(user);
            }else{
               throw new RuntimeException("Course doesnt exists");
            }
        }else{
            throw new RuntimeException("Course is invalid");
        }
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
        course.ifPresent(value -> userRepository
                .findById(userId)
                .ifPresent(user -> {
                    user.setCourse(value);
                    userRepository.save(user);
                }));
    }

    public UserDTO userLogin(final String email, final String password) {
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
            Optional<User> user = Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
            if (user.isPresent()) {
                return DataTransferUtil.getUserDTO(user.get());
            }
        }
        throw new RuntimeException("Username or password are incorrect!");

    }
}
