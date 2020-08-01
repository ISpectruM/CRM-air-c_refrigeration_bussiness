package com.ispectrum.crmclima.areas.products.models.dtos;

public class BaseAirConditionerUnitDto {

    private String id;
    private String brand;
    private String model;
    private Double price;
    private int noise;
    private Double weight;
    private int width;
    private int height;
    private int depth;
    private int airFlow;
    private int dehumidification;

    public BaseAirConditionerUnitDto() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

    public int getAirFlow() {
        return airFlow;
    }

    public void setAirFlow(int airFlow) {
        this.airFlow = airFlow;
    }

    public int getDehumidification() {
        return dehumidification;
    }

    public void setDehumidification(int dehumidification) {
        this.dehumidification = dehumidification;
    }
}
