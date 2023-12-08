package se.yrgo.service;

import se.yrgo.domain.Rental;

import java.util.List;


public interface RentalService {
    List<Rental> getAllRentals();

    public Rental createRental(Rental rental);
}