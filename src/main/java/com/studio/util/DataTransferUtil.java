package com.studio.util;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;

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
}
