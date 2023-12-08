package se.yrgo.service;

import se.yrgo.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllUsers();

    public Customer addUser(Customer customer);
}
