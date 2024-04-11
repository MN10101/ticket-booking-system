package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.entity.Customer;
import com.example.ticketbookingsystem.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerServiceInterface customerService;

    @Autowired
    public CustomerController(CustomerServiceInterface cService){
        customerService = cService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return  customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable int customerId){
        Customer customer = customerService.findById(customerId);

        if(customer == null){
            throw new RuntimeException("Customer id not found: " + customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        Customer customerDB = customerService.update(customer);
        return customerDB;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        Customer customerDB = customerService.update(customer);
        return customerDB;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.findById(customerId);

        if(customer == null){
            throw new RuntimeException("Customer id not found: " + customerId);
        }
        customerService.deleteById(customerId);

        return "The customer with ID " + customerId + " has been deleted.";
    }

}
