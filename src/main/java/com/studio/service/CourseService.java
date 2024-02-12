package com.studio.service;

import com.studio.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAll();
    void updateCourse(final CourseDTO courseDTO);
}
