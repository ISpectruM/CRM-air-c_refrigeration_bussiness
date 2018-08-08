package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.orders.entities.enums.ProphylacticType;

import javax.persistence.*;

@Entity
public class ProphylacticOrder extends BaseOrder{

    private final String SERVICE = "prophylactic";

    @Enumerated(EnumType.STRING)
    private ProphylacticType prophylacticType;

    private String product;

    public ProphylacticOrder() { }


    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public ProphylacticType getProphylacticType() {
        return this.prophylacticType;
    }

    public void setProphylacticType(ProphylacticType prophylacticType) {
        this.prophylacticType = prophylacticType;
    }

    public String getSERVICE() {
        return this.SERVICE;
    }
}
