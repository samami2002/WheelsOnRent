package se.yrgo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Customer;
import se.yrgo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllUsers() {
        return customerService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Customer> addUser(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addUser(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }
}
