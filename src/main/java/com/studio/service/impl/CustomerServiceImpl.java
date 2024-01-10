package com.studio.service.impl;

import com.studio.dto.Customer;
import com.studio.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomer(String customerId) {
        //TODO get data from database
        return new Customer();
    }

    @Override
    public List<Customer> getCustomers() {
        //TODO get data from database
        return new ArrayList<>();
    }
}
