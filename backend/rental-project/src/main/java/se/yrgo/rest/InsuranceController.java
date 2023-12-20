package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Insurance;
import se.yrgo.service.InsuranceService;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

@Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping
    public ResponseEntity<Insurance> addInsurance(@RequestBody Insurance insurance) {
        Insurance addedInsurance = insuranceService.addInsurance(insurance);
        return new ResponseEntity<>(addedInsurance, HttpStatus.CREATED);
    }
@GetMapping
    public List<Insurance> getallinsurances(){
    return insuranceService.getAllInsurances();
}
}
