package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import javax.persistence.Entity;

@Entity
public class IndoorUnit extends BaseUnit{

    private String airflow;
    private int dehumidification;

    public String getAirflow() {
        return airflow;
    }

    public void setAirflow(String airflow) {
        this.airflow = airflow;
    }

    public int getDehumidification() {
        return dehumidification;
    }

    public void setDehumidification(int dehumidification) {
        this.dehumidification = dehumidification;
    }
}