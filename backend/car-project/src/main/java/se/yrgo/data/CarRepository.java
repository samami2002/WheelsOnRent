package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByIsAvailable(Boolean isAvailable);
    List<Car> findCarByBrandIgnoreCase(String brand);
    Optional<Car> findById(Long carId);
    void deleteById(Long carId);
}
