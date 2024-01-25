package com.studio.dao;

import com.studio.domain.Customer;

import java.util.List;

public interface CustomerDao {
   void save(Customer customer) throws RuntimeException;

   List<Customer> getCustomers();
}
