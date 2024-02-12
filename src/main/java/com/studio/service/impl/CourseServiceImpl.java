package com.studio.service.impl;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;
import com.studio.repository.CourseRepository;
import com.studio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getDescription(), course.getImage(),
                        course.getPrice(), course.getDuration()))
                .toList();
    }

    public void updateCourse(final CourseDTO courseDTO) {
        courseRepository
                .findById(courseDTO.getId())
                .ifPresent(course -> {
                    course.setName(courseDTO.getName());
                    course.setDescription(courseDTO.getDescription());
                    course.setImage(courseDTO.getImage());
                    course.setPrice(courseDTO.getPrice());
                    course.setDuration(courseDTO.getDuration());
                    courseRepository.save(course);
                });
    }
}
