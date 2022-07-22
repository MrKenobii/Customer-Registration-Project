package com.anilduyguc.customerregistration.controller;


import com.anilduyguc.customerregistration.entity.Customer;
import com.anilduyguc.customerregistration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String getCustomerList(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }
    @GetMapping("show-form-for-add")
    public String showFormForAdd(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @PostMapping("save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }
}
