package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.StationRepository;
import se.yrgo.domain.Station;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public void deleteStation(Long id) {
         stationRepository.deleteById(id);
    }

    @Override
    public String getNameByID(Long id) {
        return stationRepository.getNameById(id);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
