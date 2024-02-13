package com.studio.service.impl;

import com.studio.domain.Course;
import com.studio.dto.CourseDTO;
import com.studio.repository.CourseRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
@SpringBootTest
@ActiveProfiles("test")
public class CourseServiceImplTest {

    @Autowired
    CourseServiceImpl courseService;

    @MockBean
    CourseRepository courseRepository;

    @Test
    void getAllCoursesTest(){
        when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(courseService.getAll());
    }
    @Test
    void getUpdateCourseTest(){
        CourseDTO courseDTO = Mockito.mock(CourseDTO.class);
        when(courseRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Course()));
        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(new Course());
        Assert.assertNotNull(courseService.updateCourse(courseDTO));
    }
}
