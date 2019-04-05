package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import javax.persistence.Entity;

@Entity
public class OutdoorUnit extends BaseUnit{

    private String gas;
    private int minWorkingTemp;


    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public int getMinWorkingTemp() {
        return minWorkingTemp;
    }

    public void setMinWorkingTemp(int minWorkingTemp) {
        this.minWorkingTemp = minWorkingTemp;
    }
}
