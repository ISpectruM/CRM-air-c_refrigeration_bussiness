package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseBindingModel;

public class OfferViewBindingModel extends BaseBindingModel {

    //repair, view
    private String description;

    public OfferViewBindingModel() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
