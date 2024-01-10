package com.studio.service.impl;

import org.junit.Assert;
import org.junit.Test;

public class CustomerServiceImplTest {
    public CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Test
    public void getCustomer() {

        Assert.assertNull(customerService.getCustomer("test"));
    }
}
