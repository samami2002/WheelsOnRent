package se.yrgo.service;

import se.yrgo.domain.Station;

import java.util.List;

public interface StationService {

    Station addStation(Station station);

    void deleteStation(Long id);

    String getNameByID(Long id);

    List<Station> findAll();
}
