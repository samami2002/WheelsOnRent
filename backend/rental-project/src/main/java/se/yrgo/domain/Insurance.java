package se.yrgo.domain;

import javax.persistence.*;

enum InsuranceType {FULL_COVERAGE, PARTIAL_COVER, NO_INSURANCE}

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;
    @OneToOne
    private Rental rental;

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}