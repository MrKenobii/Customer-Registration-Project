package com.anilduyguc.customerregistration.service;

import com.anilduyguc.customerregistration.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
    public List<Customer> searchCustomers(String searchName);
}
