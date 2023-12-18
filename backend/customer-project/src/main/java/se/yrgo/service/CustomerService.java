package se.yrgo.service;

import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer addAddressToCustomer(Long customerId, Address address);

    public Customer addCustomer(Customer customer);
}
