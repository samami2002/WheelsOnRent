package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Rental;
import se.yrgo.service.RentalService;

import java.util.List;

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
    public ResponseEntity<Rental> createRental(@RequestBody Rental product) {
        Rental createdRental = rentalService.createRental(product);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }
}