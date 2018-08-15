package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;
import java.util.Map;

public class MontageOrderDto extends BaseOrderDto{

    private MontageType montageType;

    private Integer productCount;

    private Double discount;

    private Map<AirConditionerDto, Integer> airConditioners;

    private Double externalPrice;

    private String otherProduct;



    public MontageOrderDto() {
    }


    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }

    public Map<AirConditionerDto, Integer> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Map<AirConditionerDto, Integer> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public Integer getProductCount() {
        return this.productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getExternalPrice() {
        return this.externalPrice;
    }

    public void setExternalPrice(Double externalPrice) {
        this.externalPrice = externalPrice;
    }

    public String getOtherProduct() {
        return otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }
}
