package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import com.ispectrum.crmclima.areas.products.entities.BaseProduct;
import com.ispectrum.crmclima.areas.products.entities.enums.AircType;
import com.ispectrum.crmclima.areas.products.entities.enums.CompressorType;

import javax.persistence.Enumerated;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class AirConditioner extends BaseProduct {

    @Enumerated
    private AircType aircType;

    @Enumerated
    private CompressorType compressorType;

    @OneToMany
    private List<IndoorUnit> indoorUnit;

    @OneToOne
    private OutdoorUnit outdoorUnit;
    private double scop;
    private double seer;
    private String heatClass;
    private String coolClass;
    private Double price;
    private String extras;

    public AircType getType() {
        return this.aircType;
    }

    public void setType(AircType type) {
        this.aircType = type;
    }

    public OutdoorUnit getOutdoorUnit() {
        return outdoorUnit;
    }

    public void setOutdoorUnit(OutdoorUnit outdoorUnit) {
        this.outdoorUnit = outdoorUnit;
    }

    public String getHeatClass() {
        return heatClass;
    }

    public void setHeatClass(String heatClass) {
        this.heatClass = heatClass;
    }

    public String getCoolClass() {
        return coolClass;
    }

    public void setCoolClass(String coolClass) {
        this.coolClass = coolClass;
    }

    public double getScop() {
        return scop;
    }

    public void setScop(double scop) {
        this.scop = scop;
    }

    public double getSeer() {
        return seer;
    }

    public void setSeer(double seer) {
        this.seer = seer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }

    public List<IndoorUnit> getIndoorUnit() {
        return indoorUnit;
    }

    public void setIndoorUnit(List<IndoorUnit> indoorUnit) {
        this.indoorUnit = indoorUnit;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
