package se.yrgo.service;

import se.yrgo.domain.Car;

import java.util.List;


public interface CarService {
    List<Car> getAllCars();

    public Car addCar(Car car);
}