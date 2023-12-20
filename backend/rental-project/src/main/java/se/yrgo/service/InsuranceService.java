package se.yrgo.service;

import se.yrgo.domain.Insurance;

import java.util.List;

public interface InsuranceService {
    List<Insurance> getAllInsurances();
Insurance addInsurance(Insurance insurance);
}
