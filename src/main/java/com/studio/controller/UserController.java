package com.studio.controller;

import com.studio.common.UserRole;
import com.studio.dto.CourseDTO;
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
@CrossOrigin(origins = "${app.frontend-origin}")
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
    @GetMapping(path = "/obtainByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(@RequestParam String email) {
        try {
            UserDTO customer = userService.getUserByEmail(email);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return saveUser(name, email, password,UserRole.CUSTOMER, null);
    }
    @PostMapping(path = "/saveUserWithCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String password,
                                               @RequestParam Long courseId ) {
        return saveUser(name, email, password,UserRole.CUSTOMER, courseId);
    }
    @PostMapping(path = "/saveAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAdmin(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return saveUser(name, email, password,UserRole.ADMIN, null);
    }

    private ResponseEntity<Object> saveUser(String name, String email, String password,UserRole userRole, Long courseId) {
        if (DataValidationUtil.isValidName(name) && DataValidationUtil.isValidEmail(email) && StringUtils.isNotBlank(password)) {
            try {
                UserDTO user = new UserDTO(name, email, password, userRole);
                if(courseId != null){
                    user = userService.saveUser(user,courseId);
                }else{
                    user = userService.saveUser(user);
                }
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
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

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUserCourse(@RequestParam long userId, @RequestParam long courseId) {
        try {
            userService.updateUser(userId, courseId);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!" + e.getMessage());
        }

    }
    @GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestParam  String email, @RequestParam String password) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.userLogin(email,password));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
        }

    }
}
