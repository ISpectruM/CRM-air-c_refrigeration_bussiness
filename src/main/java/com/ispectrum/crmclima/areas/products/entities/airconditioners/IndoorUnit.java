package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import javax.persistence.Entity;

@Entity
public class IndoorUnit extends BaseUnit{

    private String airFlow;
    private int dehumidification;

    public String getAirFlow() {
        return airFlow;
    }

    public void setAirFlow(String airFlow) {
        this.airFlow = airFlow;
    }

    public int getDehumidification() {
        return dehumidification;
    }

    public void setDehumidification(int dehumidification) {
        this.dehumidification = dehumidification;
    }
}