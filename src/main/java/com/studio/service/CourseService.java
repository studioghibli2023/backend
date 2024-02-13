package com.studio.service;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAll();
    Course updateCourse(final CourseDTO courseDTO);
}
