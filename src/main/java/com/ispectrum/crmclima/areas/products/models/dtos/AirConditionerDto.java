package com.ispectrum.crmclima.areas.products.models.dtos;

import com.ispectrum.crmclima.areas.products.entities.enums.SplitType;
import com.ispectrum.crmclima.areas.products.entities.enums.Condition;
import com.ispectrum.crmclima.areas.products.entities.enums.ProductType;

public class AirConditionerDto{

    private String id;

    private String brand;

    private String model;

    private Double price;

    private SplitType splitType;

    private ProductType productType;

    private Condition productCondition;

    private long indoorUnitId;

    private long outdoorUnitId;

    public AirConditionerDto() {
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

    public SplitType getSplitType() {
        return this.splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public Condition getProductCondition() {
        return this.productCondition;
    }

    public void setProductCondition(Condition productCondition) {
        this.productCondition = productCondition;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
