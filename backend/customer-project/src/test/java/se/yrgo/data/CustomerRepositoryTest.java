package se.yrgo.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.yrgo.domain.Address;
import se.yrgo.domain.Customer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindCustomer() {
        Customer customer = new Customer(
                "John Doe",
                "123456789",
                "john.doe@example.com",
                "DL123",
                "1234567890",
                new Address(null, "Street", "City", "12345", "Country")
        );
        customerRepository.save(customer);

        Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getId());
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("John Doe", retrievedCustomer.get().getName());
    }

    @Test
    public void testFindByNationalIdentificationNumber() {
        Customer customer = new Customer(
                "Jane Doe",
                "987654321",
                "jane.doe@example.com",
                "DL456",
                "9876543210",
                new Address(null, "Avenue", "Town", "54321", "Country")
        );
        customerRepository.save(customer);

        Optional<Customer> retrievedCustomer = customerRepository.findByNationalIdentificationNumber("987654321");
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("Jane Doe", retrievedCustomer.get().getName());
    }

    @Test
    public void testFindAllCustomers() {
        Customer customer1 = new Customer(
                "Alice",
                "111111111",
                "alice@example.com",
                "DL111",
                "1111111111",
                new Address(null, "Street1", "City1", "12345", "Country1")
        );
        Customer customer2 = new Customer(
                "Bob",
                "222222222",
                "bob@example.com",
                "DL222",
                "2222222222",
                new Address(null, "Street2", "City2", "54321", "Country2")
        );
        customerRepository.saveAll(List.of(customer1, customer2));

        List<Customer> allCustomers = customerRepository.findAll();
        assertEquals(2, allCustomers.size());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(
                "Old Name",
                "123456789",
                "old@example.com",
                "DL123",
                "1234567890",
                new Address(null, "OldStreet", "OldCity", "Old12345", "OldCountry")
        );
        customerRepository.save(customer);

        customer.setName("New Name");
        customer.setEmail("new@example.com");
        customerRepository.save(customer);

        Optional<Customer> updatedCustomer = customerRepository.findById(customer.getId());
        assertTrue(updatedCustomer.isPresent());
        assertEquals("New Name", updatedCustomer.get().getName());
        assertEquals("new@example.com", updatedCustomer.get().getEmail());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer(
                "ToDelete",
                "333333333",
                "toDelete@example.com",
                "DL333",
                "3333333333",
                new Address(null, "DeleteStreet", "DeleteCity", "Delete12345", "DeleteCountry")
        );
        customerRepository.save(customer);

        customerRepository.deleteById(customer.getId());

        Optional<Customer> deletedCustomer = customerRepository.findById(customer.getId());
        assertTrue(deletedCustomer.isEmpty());
    }

}
