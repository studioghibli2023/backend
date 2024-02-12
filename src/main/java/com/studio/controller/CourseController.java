package com.studio.controller;

import com.studio.dto.CourseDTO;
import com.studio.service.CourseService;
import com.studio.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService = new CourseServiceImpl();

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCourses() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }

    }

    @GetMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCourse(@RequestParam long id, @RequestParam String name, @RequestParam String description, @RequestParam String image,
                                               @RequestParam BigDecimal price, @RequestParam int duration) {
        try {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(name);
            courseDTO.setId(id);
            courseDTO.setDescription(description);
            courseDTO.setPrice(price);
            courseDTO.setImage(image);
            courseDTO.setDuration(duration);
            courseService.updateCourse(courseDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }

    }
}
