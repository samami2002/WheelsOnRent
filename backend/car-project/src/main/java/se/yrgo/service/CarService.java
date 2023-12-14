package se.yrgo.service;

import se.yrgo.domain.Car;

import java.util.List;


public interface CarService {
    List<Car> getAllCars();

    public Car addCar(Car car);

    Car updateCarAvailability(Long carId, boolean newAvailability);

    void deleteCar(Long carId);

    List<Car> getAllAvailableCars(boolean isAvailable);

    List<Car> getCarsByBrand(String brand);
}