package com.studio.service.impl;

import com.studio.dao.CustomerDao;
import com.studio.dao.impl.CustomerDaoImpl;
import com.studio.dto.CustomerDTO;
import com.studio.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public CustomerDTO getCustomer(String customerId) {
        //TODO get data from database
        return null;
    }

    @Override

    public void saveCustomer(CustomerDTO customer) throws RuntimeException{
        com.studio.domain.Customer customerDomain = new com.studio.domain.Customer();
        customerDomain.setName(customer.getName());
        customerDomain.setEmail(customer.getEmail());
        customerDao.save(customerDomain);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<com.studio.domain.Customer> customers = customerDao.getCustomers();
        return customers.stream()
                .map(cus -> new CustomerDTO(cus.getId(), cus.getName(), cus.getEmail()))
                .collect(Collectors.toList());
    }
}
