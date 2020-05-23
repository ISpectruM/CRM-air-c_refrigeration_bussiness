package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class IndoorUnit extends BaseUnit{

    private String airFlow;
    private int dehumidification;

    @ManyToMany(mappedBy = "indoorUnits")
    private List<OutdoorUnit> outdoorUnits;


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

    public List<OutdoorUnit> getOutdoorUnits() {
        return outdoorUnits;
    }

    public void setOutdoorUnits(List<OutdoorUnit> outdoorUnits) {
        this.outdoorUnits = outdoorUnits;
    }
}