package se.yrgo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;
import se.yrgo.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PatchMapping("/{id}/address")
    public ResponseEntity<Customer> addAddressToCustomer(
            @PathVariable Long id,
            @RequestBody Address address
    ) {
        Customer updatedCustomer = customerService.addAddressToCustomer(id, address);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }
}
