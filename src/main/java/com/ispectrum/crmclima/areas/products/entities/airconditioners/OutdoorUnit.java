package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import com.ispectrum.crmclima.areas.products.entities.enums.SplitType;

import javax.persistence.*;
import java.util.List;

@Entity
public class OutdoorUnit extends BaseUnit {
    @Enumerated
    private SplitType splitType;
    private String coolPower;
    private String heatPower;
    private String coolConsumption;
    private String heatConsumption;
    private String gas;
    private int minWorkingTemp;

    @ManyToMany
    @JoinTable(
            name = "outdoors_indoors",
            joinColumns = @JoinColumn(name = "outdoor_id"),
            inverseJoinColumns = @JoinColumn(name = "indoor_id"))
    private List<IndoorUnit> indoorUnits;

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

    public String getCoolPower() {
        return coolPower;
    }

    public void setCoolPower(String coolPower) {
        this.coolPower = coolPower;
    }

    public String getHeatPower() {
        return heatPower;
    }

    public void setHeatPower(String heatPower) {
        this.heatPower = heatPower;
    }

    public String getCoolConsumption() {
        return coolConsumption;
    }

    public void setCoolConsumption(String coolConsumption) {
        this.coolConsumption = coolConsumption;
    }

    public String getHeatConsumption() {
        return heatConsumption;
    }

    public void setHeatConsumption(String heatConsumption) {
        this.heatConsumption = heatConsumption;
    }

    public List<IndoorUnit> getIndoorUnits() {
        return indoorUnits;
    }

    public void setIndoorUnits(List<IndoorUnit> indoorUnit) {
        this.indoorUnits = indoorUnit;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
}
