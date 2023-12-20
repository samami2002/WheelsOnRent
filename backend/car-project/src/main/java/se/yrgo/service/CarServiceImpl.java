package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.CarRepository;
import se.yrgo.domain.Car;

import java.util.List;
import java.util.Optional;

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
        car.setIsAvailable(true);
        return carRepository.save(car);
    }

    @Override
    public Car updateCarAvailability(Long carId, boolean newAvailability) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setIsAvailable(newAvailability);
            return carRepository.save(car);
        } else {
            throw new RuntimeException("Car not found with ID: " + carId);
        }
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public List<Car> getAllAvailableCars(boolean isAvailable) {
        return carRepository.findAllByIsAvailable(isAvailable);    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findCarByBrandIgnoreCase(brand);
    }
}
