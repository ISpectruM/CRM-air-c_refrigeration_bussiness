package com.ispectrum.crmclima.areas.products.models.bindingmodels;

public class IndoorUnitBindingModel {

    private String aircType;
    private String compressorType;
    private String model;
    private String noise;
    private int width;
    private int height;
    private int depth;
    private Double weight;
    private Double price;
    private String airflow;
    private int dehumidification;

    public String getAircType() {
        return aircType;
    }

    public void setAircType(String aircType) {
        this.aircType = aircType;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

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
