package com.studio.controller;

import com.studio.dto.Customer;
import com.studio.service.CustomerService;
import com.studio.service.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController

public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCustomer(@RequestParam String customerId) {
        if (customerId == null) {
            return null;
        } else {
            Customer customer = customerService.getCustomer(customerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer);
        }
    }
}
