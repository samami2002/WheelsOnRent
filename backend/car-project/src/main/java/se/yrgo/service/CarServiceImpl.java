package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.CarRepository;
import se.yrgo.domain.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllAvailableCars() {
        return carRepository.findAllByAvailability();
    }
}
