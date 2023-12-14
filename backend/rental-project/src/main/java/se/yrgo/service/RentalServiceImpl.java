package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.RentalRepository;
import se.yrgo.domain.Rental;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }


    @Override
    public List<Rental> getRentalsByCustomerIdBetweenDates(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return rentalRepository.findByCustomerIdAndRentalDateTimeBetween(customerId, startDateTime, endDateTime);
    }

    @Override
    public List<Rental> getRentalsByCarIdBetweenDates(Long carId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return rentalRepository.findByCarIdAndRentalDateTimeBetween(carId, startDateTime, endDateTime);
    }

    @Override
    public List<Rental> getRentalsByCustomerId(Long customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }

}
