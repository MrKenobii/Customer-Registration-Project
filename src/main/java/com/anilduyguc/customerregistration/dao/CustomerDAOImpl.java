package com.anilduyguc.customerregistration.dao;

import com.anilduyguc.customerregistration.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Locale;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory; // it should match the exactly same name of bean id="sessionFactory" in xml file

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
//        Session session = sessionFactory.getCurrentSession();
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        //Session session = sessionFactory.getCurrentSession();
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        if(searchName != null && searchName.trim().length() > 0){
            query = session.createQuery("from Customer where lower(firstName) like: name" +
                    " or lower(lastName) like: name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
