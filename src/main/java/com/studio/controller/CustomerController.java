package com.studio.controller;

import com.studio.dto.CustomerDTO;
import com.studio.service.CustomerService;
import com.studio.service.impl.CustomerServiceImpl;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCustomer(@RequestParam String customerId) {
        if (customerId == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid data");
        } else {
            //CustomerDTO customer = customerService.getCustomer(customerId);
            //TODO commenting for test without database connection
            CustomerDTO customer = new CustomerDTO("Ruth","ruth@atu.ie");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
        }
    }

    @GetMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestParam String name, @RequestParam String email) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(email)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid data");
        } else {
            try {
                CustomerDTO customer = new CustomerDTO(name, email);
                customerService.saveCustomer(customer);
                return ResponseEntity.status(HttpStatus.CREATED).body(customer);
            } catch (RuntimeException e) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Something went wrong!");
            }
        }
    }
}
