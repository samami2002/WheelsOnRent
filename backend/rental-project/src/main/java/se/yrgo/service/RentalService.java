package se.yrgo.service;

import se.yrgo.domain.Rental;

import java.time.LocalDateTime;
import java.util.List;


public interface RentalService {
    List<Rental> getAllRentals();

    public Rental createRental(Rental rental);

    List<Rental> getRentalsByCustomerIdBetweenDates(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Rental> getRentalsByCarIdBetweenDates(Long carId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Rental> getRentalsByCustomerId(Long customerId);
}