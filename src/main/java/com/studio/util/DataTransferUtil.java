package com.studio.util;

import com.studio.common.UserRole;
import com.studio.domain.Course;
import com.studio.domain.User;
import com.studio.dto.CourseDTO;
import com.studio.dto.UserDTO;

public class DataTransferUtil {

    public static CourseDTO getCourseDTO(final Course course) {
        if(course != null) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(course.getName());
            courseDTO.setId(course.getId());
            courseDTO.setDescription(course.getDescription());
            courseDTO.setPrice(course.getPrice());
            courseDTO.setImage(course.getImage());
            courseDTO.setDuration(course.getDuration());
            return courseDTO;
        }
       return null;
    }
    public static Course getCourse(final CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setId(courseDTO.getId());
        course.setDescription(courseDTO.getDescription());
        course.setPrice(courseDTO.getPrice());
        course.setImage(courseDTO.getImage());
        course.setDuration(courseDTO.getDuration());
        return course;
    }
    public static UserDTO getUserDTO(final User userDomain){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserRole(UserRole.getUserRole(userDomain.getRole()));
        userDTO.setCourse(getCourseDTO(userDomain.getCourse()));
        userDTO.setEmail(userDomain.getEmail());
        userDTO.setId(userDomain.getId());
        userDTO.setPassword(userDomain.getPassword());
        userDTO.setName(userDomain.getName());
        return userDTO;
    }
    public static User getUserDomain(final UserDTO user){
        User userDomain = new User();
        userDomain.setName(user.getName());
        userDomain.setEmail(user.getEmail());
        userDomain.setPassword(user.getPassword());
        userDomain.setRole(user.getUserRole().getRoleNumber());
        return userDomain;
    }
}
