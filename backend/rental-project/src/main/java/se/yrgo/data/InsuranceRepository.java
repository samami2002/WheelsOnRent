package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.domain.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,String> {
}
