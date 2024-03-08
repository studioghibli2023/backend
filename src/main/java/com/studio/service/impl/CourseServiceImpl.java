package com.studio.service.impl;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;
import com.studio.repository.CourseRepository;
import com.studio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Course updateCourse(final CourseDTO courseDTO) {

        Optional<Course> course = courseRepository.findById(courseDTO.getId());
        if (course.isPresent()) {
            Course courseDomain = course.get();
            courseDomain.setName(courseDTO.getName());
            courseDomain.setDescription(courseDTO.getDescription());
            courseDomain.setImage(courseDTO.getImage());
            courseDomain.setPrice(courseDTO.getPrice());
            courseDomain.setDuration(courseDTO.getDuration());
            return courseRepository.save(courseDomain);
        } else {
            throw new RuntimeException("Course ID does not exist!");
        }
    }
    public Course saveCourse(final CourseDTO courseDTO) {
            Course courseDomain = new Course();
            courseDomain.setName(courseDTO.getName());
            courseDomain.setDescription(courseDTO.getDescription());
            courseDomain.setImage(courseDTO.getImage());
            courseDomain.setPrice(courseDTO.getPrice());
            courseDomain.setDuration(courseDTO.getDuration());
            return courseRepository.save(courseDomain);
    }
}