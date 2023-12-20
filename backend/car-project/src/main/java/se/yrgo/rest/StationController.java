package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Station;
import se.yrgo.service.StationService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    @PostMapping
    public ResponseEntity<Station> addStation(@RequestBody Station carRentalStation) {
        Station station = stationService.addStation(carRentalStation);
        return new ResponseEntity<>(station, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Station> findAll()
    {
        return stationService.findAll();
    }

    @GetMapping("/delete")
    public void deleteStationById(@RequestBody Long id)
    {
        stationService.deleteStation(id);
    }

    @GetMapping("/by-id")
    public String getNameById(@RequestBody Long id)
    {
        return stationService.getNameByID(id);
    }
}
