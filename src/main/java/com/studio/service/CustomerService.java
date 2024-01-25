package com.studio.service;

import com.studio.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomer(String customerId);

    List<CustomerDTO> getCustomers();

    void saveCustomer(CustomerDTO customer) throws RuntimeException;
}
