package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
