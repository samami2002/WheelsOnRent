package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Car;
import se.yrgo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<Car> addProduct(@RequestBody Car car) {
        Car addedCar = carService.addCar(car);
        return new ResponseEntity<>(addedCar, HttpStatus.CREATED);
    }

    @GetMapping("/Available-cars")
    public List<Car> getAllAvailableCar(){
        return carService.getAllAvailableCars(true);
    }
}