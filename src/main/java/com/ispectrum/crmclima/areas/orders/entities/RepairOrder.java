package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;

import javax.persistence.*;

@Entity
public class RepairOrder extends BaseOrder{

    private final String service = "repair";

    @Enumerated(EnumType.STRING)
    private RepairType repairType;


    public RepairOrder() {
    }


    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public String getService() {
        return this.service;
    }

    @Override
    public Double getForPayment() {
        Double price = this.getPrice();
        Double deposit = this.getDeposit();
        if (deposit != null && price != null){
            return price - deposit;
        }
        return super.getForPayment();
    }
}
