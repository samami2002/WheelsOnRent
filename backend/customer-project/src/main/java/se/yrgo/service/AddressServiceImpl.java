package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.AddressRepository;
import se.yrgo.domain.Address;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

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
        return addressRepository.save(address);
    }
}
