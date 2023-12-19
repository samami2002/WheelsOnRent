package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Rental;
import se.yrgo.service.RentalService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        Rental createdRental = rentalService.createRental(rental);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }

    //http://localhost:8092/rentals/by-customer-and-dates?customerId=2&startDate=2022-01-01T00:00:00&endDate=2023-01-01T00:00:00
    @GetMapping("/by-customer-and-dates")
    public ResponseEntity<List<Rental>> getRentalsByCustomerIdBetweenDates(
            @RequestParam Long customerId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);

        List<Rental> rentals = rentalService.getRentalsByCustomerIdBetweenDates(customerId, startDateTime, endDateTime);
        return ResponseEntity.ok(rentals);
    }

    //http://localhost:8092/rentals/by-car-and-dates?carId=2&startDate=2022-01-01T00:00:00&endDate=2023-01-01T00:00:00
    @GetMapping("/by-car-and-dates")
    public ResponseEntity<List<Rental>> getRentalsByCarIdBetweenDates(
            @RequestParam Long carId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);

        List<Rental> rentals = rentalService.getRentalsByCarIdBetweenDates(carId, startDateTime, endDateTime);
        return ResponseEntity.ok(rentals);
    }
     @GetMapping("/alldates-by-customer/{customerId}")
    public ResponseEntity<List<Rental>> getRentalsByCustomerId(@PathVariable long customerId) {
        List<Rental> rentals = rentalService.getRentalsByCustomerId(customerId);
        return ResponseEntity.ok(rentals);
    }
}