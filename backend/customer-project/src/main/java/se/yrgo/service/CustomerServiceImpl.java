package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.CustomerRepository;
import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;
import se.yrgo.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElseThrow(() -> new NotFoundException("Customer not found with id: " + customerId));
    }

    @Override
    public Customer addAddressToCustomer(Long customerId, Address address) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setAddress(address);
            return customerRepository.save(customer);
        }

        throw new NotFoundException("Customer not found with ID: " + customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
