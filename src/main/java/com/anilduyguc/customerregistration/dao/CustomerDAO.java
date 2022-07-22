package com.anilduyguc.customerregistration.dao;

import com.anilduyguc.customerregistration.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
}
