package com.ispectrum.crmclima.areas.products.entities;

import com.ispectrum.crmclima.areas.products.entities.enums.Condition;
import com.ispectrum.crmclima.areas.products.entities.enums.ProductType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String brand;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Enumerated
    private Condition productCondition;


    protected BaseProduct() {
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Condition getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(Condition productCondition) {
        this.productCondition = productCondition;
    }
}
