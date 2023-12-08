package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
