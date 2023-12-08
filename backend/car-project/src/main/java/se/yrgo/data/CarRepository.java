package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
