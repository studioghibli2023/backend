package com.studio.dao.impl;

import com.studio.dao.CustomerDao;
import com.studio.domain.Customer;
import com.studio.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    public void save(Customer customer) throws RuntimeException{
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error saving customer.");
        }
    }

    public List<Customer> getCustomers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        }
    }
}
