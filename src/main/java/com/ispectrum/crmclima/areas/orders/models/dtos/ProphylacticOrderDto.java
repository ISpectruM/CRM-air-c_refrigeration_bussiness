package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.orders.entities.enums.ProphylacticType;

public class ProphylacticOrderDto extends BaseOrderDto{

    private ProphylacticType prophylacticType;

    private String product;


    public ProphylacticOrderDto() {
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public ProphylacticType getProphylacticType() {
        return prophylacticType;
    }

    public void setProphylacticType(ProphylacticType prophylacticType) {
        this.prophylacticType = prophylacticType;
    }
}
