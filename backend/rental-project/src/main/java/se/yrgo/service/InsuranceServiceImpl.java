package se.yrgo.service;

import org.springframework.stereotype.Service;
import se.yrgo.data.InsuranceRepository;
import se.yrgo.domain.Insurance;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance addInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }
}
