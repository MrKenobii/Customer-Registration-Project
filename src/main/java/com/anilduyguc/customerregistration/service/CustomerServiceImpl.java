package com.anilduyguc.customerregistration.service;

import com.anilduyguc.customerregistration.dao.CustomerDAO;
import com.anilduyguc.customerregistration.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }
}
