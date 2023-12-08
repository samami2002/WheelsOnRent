package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.CustomerRepository;
import se.yrgo.domain.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addUser(Customer customer) {
        return customerRepository.save(customer);
    }
}
