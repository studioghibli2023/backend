package com.studio.service.impl;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;
import com.studio.repository.CourseRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {


    @InjectMocks
    CourseServiceImpl courseService;

    @Mock
    CourseRepository courseRepository;

    @Test
    public void getAllCoursesTest() {
        when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(courseService.getAll());
    }

    @Test
    public void getUpdateCourseTest() {
        CourseDTO courseDTO = Mockito.mock(CourseDTO.class);
        when(courseRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Course()));
        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(new Course());
        Assert.assertNotNull(courseService.updateCourse(courseDTO));
    }
}
