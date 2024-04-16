package com.studio.controller;

import com.studio.dto.CourseDTO;
import com.studio.service.CourseService;
import com.studio.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "${app.frontend-origin}")
public class CourseController {

    public static final String SOMETHING_WENT_WRONG = "Something went wrong!";
    @Autowired
    private CourseService courseService = new CourseServiceImpl();

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCourses() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SOMETHING_WENT_WRONG);
        }

    }

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SOMETHING_WENT_WRONG);
        }

    }
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam String image,
                                               @RequestParam BigDecimal price, @RequestParam int duration) {
        try {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(name);
            courseDTO.setDescription(description);
            courseDTO.setPrice(price);
            courseDTO.setImage(image);
            courseDTO.setDuration(duration);
            courseService.saveCourse(courseDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SOMETHING_WENT_WRONG);
        }

    }
}
