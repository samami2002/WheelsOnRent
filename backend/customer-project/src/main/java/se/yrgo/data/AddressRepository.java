package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
