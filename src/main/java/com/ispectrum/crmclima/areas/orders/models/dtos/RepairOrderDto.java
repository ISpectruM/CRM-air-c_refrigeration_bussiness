package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;


public class RepairOrderDto extends BaseOrderDto{

    private RepairType repairType;

    public RepairOrderDto() {
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

}
