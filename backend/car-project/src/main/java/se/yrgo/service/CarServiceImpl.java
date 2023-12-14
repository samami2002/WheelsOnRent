package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.CarRepository;
import se.yrgo.domain.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
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
    public List<Car> getAllAvailableCars(boolean isAvailable) {
        return carRepository.findAllByIsAvailable(isAvailable);    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findCarByBrandIgnoreCase(brand);
    }
}
