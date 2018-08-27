package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.constants.Messages;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class OfferViewBindingModel extends BaseOrderBindingModel {

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String montageType;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double externalPrice;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double discount;


    public OfferViewBindingModel() {}


    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }

    public Double getExternalPrice() {
        return externalPrice;
    }

    public void setExternalPrice(Double externalPrice) {
        this.externalPrice = externalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
