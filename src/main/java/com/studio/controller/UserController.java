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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
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

    @GetMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        if (DataValidationUtil.isValidName(name) && DataValidationUtil.isValidEmail(email) && StringUtils.isNotBlank(password)) {
            try {
                UserDTO user = new UserDTO(name, email, password, UserRole.CUSTOMER);
                userService.saveUser(user);
                return ResponseEntity.status(HttpStatus.CREATED).body(user);
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
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
}
