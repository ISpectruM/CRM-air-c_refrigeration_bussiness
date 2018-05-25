package com.ispectrum.crmclima.areas.orders.models.bindingModels.repair_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.constants.Messages;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class RepairBindingModel extends BaseOrderBindingModel {

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String repairType;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;

    private String otherProduct;

    public RepairBindingModel() {
    }


    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getRepairType() {
        return this.repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }


    public String getOtherProduct() {
        return this.otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }
}
