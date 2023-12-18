package se.yrgo.service;

import se.yrgo.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddresses();

    Optional<Address> getAddressById(Long id);

    Address addAddress(Address address);
}
