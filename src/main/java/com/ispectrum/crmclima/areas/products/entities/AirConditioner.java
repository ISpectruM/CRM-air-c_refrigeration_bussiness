package com.ispectrum.crmclima.areas.products.entities;

import com.ispectrum.crmclima.areas.products.entities.enums.AircType;
import com.ispectrum.crmclima.areas.products.entities.enums.Condition;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class AirConditioner extends BaseProduct {

    @Enumerated
    private AircType aircType;

    @Enumerated
    private Condition productCondition;


    public AirConditioner() {
    }

    public AircType getType() {
        return this.aircType;
    }

    public void setType(AircType type) {
        this.aircType = type;
    }

    public Condition getProductCondition() {
        return this.productCondition;
    }

    public void setProductCondition(Condition productCondition) {
        this.productCondition = productCondition;
    }
}
