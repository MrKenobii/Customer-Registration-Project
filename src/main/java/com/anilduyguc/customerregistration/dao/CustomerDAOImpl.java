package com.anilduyguc.customerregistration.dao;

import com.anilduyguc.customerregistration.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory; // it should match the exactly same name of bean id="sessionFactory" in xml file

    @Override
    public List<Customer> getCustomers() {
        Session session =  sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
