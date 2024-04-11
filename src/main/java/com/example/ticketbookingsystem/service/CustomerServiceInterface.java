package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

        List<Customer> findAll();

        Customer findById(int id);

        Customer update(Customer customer);

        void deleteById(int id);
}
