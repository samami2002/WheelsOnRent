package se.yrgo.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.yrgo.domain.Address;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSaveAndFindAddress() {
        Address address = new Address(null, "Street", "City", "12345", "Country");
        addressRepository.save(address);

        Optional<Address> retrievedAddress = addressRepository.findById(address.getId());
        assertTrue(retrievedAddress.isPresent());
        assertEquals("Street", retrievedAddress.get().getStreet());
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address(null, "OldStreet", "OldCity", "12345", "OldCountry");
        addressRepository.save(address);

        address.setStreet("NewStreet");
        address.setCity("NewCity");
        addressRepository.save(address);

        Optional<Address> updatedAddress = addressRepository.findById(address.getId());
        assertTrue(updatedAddress.isPresent());
        assertEquals("NewStreet", updatedAddress.get().getStreet());
        assertEquals("NewCity", updatedAddress.get().getCity());
    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address(null, "ToDelete", "DeleteCity", "12345", "DeleteCountry");
        addressRepository.save(address);

        addressRepository.deleteById(address.getId());

        Optional<Address> deletedAddress = addressRepository.findById(address.getId());
        assertTrue(deletedAddress.isEmpty());
    }

}
