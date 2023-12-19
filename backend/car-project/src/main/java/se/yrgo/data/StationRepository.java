package se.yrgo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.yrgo.domain.Station;

import java.util.List;
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    @Override
    List<Station> findAll();
    @Query(value = "SELECT name from Station where id =?1")
    String getNameById(Long id);

    void deleteById(Long id);

}
