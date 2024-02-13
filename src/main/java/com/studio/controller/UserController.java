package com.studio.controller;

import com.studio.common.UserRole;
import com.studio.dto.UserDTO;
import com.studio.service.UserService;
import com.studio.service.impl.UserServiceImpl;
import com.studio.util.DataValidationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @GetMapping(path = "/obtain", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@RequestParam long customerId) {
        try {
            UserDTO customer = userService.getUser(customerId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        if (DataValidationUtil.isValidName(name) && DataValidationUtil.isValidEmail(email) && StringUtils.isNotBlank(password)) {
            try {
                UserDTO user = new UserDTO(name, email, password, UserRole.CUSTOMER);
                userService.saveUser(user);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!" + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data");
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.getUsers());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }

    }

    @GetMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUserCourse(@RequestParam long userId, @RequestParam long courseId) {
        try {
            userService.updateUser(userId, courseId);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }

    }
}
