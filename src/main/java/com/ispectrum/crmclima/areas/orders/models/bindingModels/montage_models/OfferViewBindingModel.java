package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.constants.Messages;

import javax.validation.constraints.NotEmpty;

public class OfferViewBindingModel extends BaseOrderBindingModel {

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String montageType;


    public OfferViewBindingModel() {
    }


    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }
}
