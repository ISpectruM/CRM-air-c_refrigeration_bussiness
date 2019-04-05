package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseUnit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String model;
    private String coolPower;
    private String heatPower;
    private String coolConsumption;
    private String heatConsumption;
    private String noise;
    private int width;
    private int height;
    private int depth;
    private Double weight;

    public String getDimensions() {
        return height+"/"+width+"/"+depth;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
