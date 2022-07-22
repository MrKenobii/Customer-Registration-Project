package com.anilduyguc.customerregistration.controller;

import com.anilduyguc.customerregistration.dao.CustomerDAO;
import com.anilduyguc.customerregistration.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String getCustomerList(Model model) {
        List<Customer> customers = customerDAO.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }
}
