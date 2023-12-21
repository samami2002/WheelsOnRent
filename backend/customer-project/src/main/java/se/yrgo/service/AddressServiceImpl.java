package se.yrgo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.yrgo.data.AddressRepository;
import se.yrgo.domain.Address;
import se.yrgo.exception.AddressAdditionException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address addAddress(Address address) {
        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            logger.error("Error occurred while adding an address: {}", e.getMessage());
            throw new AddressAdditionException("Failed to add address.", e);
        }
    }

}
