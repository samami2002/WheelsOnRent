package se.yrgo.service;

import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer addAddressToCustomer(Long customerId, Address address);

    public Customer addCustomer(Customer customer);
}
