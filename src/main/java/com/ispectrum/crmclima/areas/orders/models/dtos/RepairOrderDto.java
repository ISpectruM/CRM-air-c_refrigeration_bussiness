package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;


public class RepairOrderDto extends BaseOrderDto{

    private RepairType repairType;

    private String product;

    public RepairOrderDto() {
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
