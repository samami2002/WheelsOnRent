package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import se.yrgo.domain.Car;
import se.yrgo.service.CarService;

import java.util.List;

@CrossOrigin(origins = "*")
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
    public List<Car> getAllAvailableCar() {
        return carService.getAllAvailableCars(true);
    }
    //http://localhost:8091/cars/by-brand?brand=<brand>
    @GetMapping("/by-brand")
    public List<Car> getCarsByBrand(@RequestParam String brand) {

            return carService.getCarsByBrand(brand);
    }
}

