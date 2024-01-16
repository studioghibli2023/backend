package com.studio.service;

import com.studio.dto.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String customerId);

    List<Customer> getCustomers();
}
