package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Rental;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerIdAndRentalDateTimeBetween(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    List<Rental> findByCarIdAndRentalDateTimeBetween(Long carId, LocalDateTime startDateTime, LocalDateTime endDateTime);


}
