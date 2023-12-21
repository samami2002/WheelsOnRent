package se.yrgo.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import se.yrgo.data.CustomerRepository;
import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;
import se.yrgo.exception.AddressAdditionException;
import se.yrgo.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    // Test retrieving all customers
    @Test
    public void testGetAllCustomers() {
        // Arrange
        when(customerRepository.findAll()).thenReturn(List.of(new Customer("John Doe", "123456789",
                        "john.doe@example.com", "DL123", "1234567890",
                        new Address(null, "Street", "City", "12345", "Country")),
                new Customer("Jane Doe", "987654321",
                        "jane.doe@example.com", "DL456", "9876543210",
                        new Address(null, "Avenue", "Town", "54321", "Country"))));

        // Act
        List<Customer> allCustomers = customerService.getAllCustomers();

        // Assert
        assertEquals(2, allCustomers.size());
    }

    // Test retrieving a customer by ID
    @Test
    public void testGetCustomerById() {
        // Arrange
        Long customerId = 1L;
        Customer expectedCustomer = new Customer("John Doe", "123456789", "john.doe@example.com", "DL123", "1234567890",
                new Address(1L, "Street", "City", "12345", "Country"));
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(expectedCustomer));

        // Act
        Customer actualCustomer = customerService.getCustomerById(customerId);

        // Assert
        assertNotNull(actualCustomer);
        assertEquals(expectedCustomer.getName(), actualCustomer.getName());
    }

    // Test retrieving a customer by ID when not found
    @Test
    public void testGetCustomerByIdNotFound() {
        // Arrange
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> customerService.getCustomerById(customerId));
    }

    // Test retrieving a customer by national identification number
    @Test
    public void testFindByNationalIdentificationNumber() {
        // Arrange
        String nationalId = "123456789";
        Customer expectedCustomer = new Customer("John Doe", nationalId, "john.doe@example.com", "DL123", "1234567890",
                new Address(1L, "Street", "City", "12345", "Country"));
        when(customerRepository.findByNationalIdentificationNumber(nationalId)).thenReturn(Optional.of(expectedCustomer));

        // Act
        Optional<Customer> actualCustomer = customerService.findByNationalIdentificationNumber(nationalId);

        // Assert
        assertTrue(actualCustomer.isPresent());
        assertEquals(expectedCustomer.getName(), actualCustomer.get().getName());
    }

    // Test adding an address to an existing customer
    @Test
    public void testAddAddressToCustomer() {
        // Arrange
        Long customerId = 1L;
        Address addressToAdd = new Address(null, "Street", "City", "12345", "Country");

        Customer existingCustomer = new Customer("John Doe", "123456789", "john.doe@example.com", "DL123", "1234567890",
                new Address());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Act
        Customer updatedCustomer = customerService.addAddressToCustomer(customerId, addressToAdd);

        // Assert
        assertNotNull(updatedCustomer.getAddress());
        assertEquals(addressToAdd, updatedCustomer.getAddress());
    }

    // Test adding an address to a non-existing customer
    @Test
    public void testAddAddressToCustomerNotFound() {
        // Arrange
        Long customerId = 1L;
        Address addressToAdd = new Address(null, "Street", "City", "12345", "Country");
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> customerService.addAddressToCustomer(customerId, addressToAdd));
    }

    // Test adding an address to a customer with a save failure
    @Test
    public void testAddAddressToCustomerException() {
        // Arrange
        Long customerId = 1L;
        Address addressToAdd = new Address(null, "Street", "City", "12345", "Country");

        Customer existingCustomer = new Customer("John Doe", "123456789", "john.doe@example.com", "DL123", "1234567890",
                new Address());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenThrow(new RuntimeException("Failed to save"));

        // Act and Assert
        assertThrows(AddressAdditionException.class, () -> customerService.addAddressToCustomer(customerId, addressToAdd));
    }

    // Test adding a new customer
    @Test
    public void testAddCustomer() {
        // Arrange
        Customer customerToAdd = new Customer("John Doe", "123456789", "john.doe@example.com", "DL123", "1234567890",
                new Address(null, "Street", "City", "12345", "Country"));
        when(customerRepository.save(customerToAdd)).thenReturn(customerToAdd);

        // Act
        Customer addedCustomer = customerService.addCustomer(customerToAdd);

        // Assert
        assertNotNull(addedCustomer);
        assertEquals(customerToAdd.getName(), addedCustomer.getName());
    }

    // Add more test cases for other methods in CustomerServiceImpl
}
