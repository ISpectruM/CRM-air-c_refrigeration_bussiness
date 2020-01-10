package com.ispectrum.crmclima.areas.products.entities.airconditioners;

import com.ispectrum.crmclima.areas.products.entities.enums.AircType;
import com.ispectrum.crmclima.areas.products.entities.enums.CompressorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseUnit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Enumerated
    private AircType aircType;

    @Enumerated
    private CompressorType compressorType;

    private String model;
    private String brand;
    private String noise;
    private int width;
    private int height;
    private int depth;
    private Double weight;
    private Double price;

    public String getDimensions() {
        return height+"/"+width+"/"+depth;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AircType getAircType() {
        return aircType;
    }

    public void setAircType(AircType aircType) {
        this.aircType = aircType;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
