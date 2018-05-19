package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;


public class EditMontageOrderBindingModel extends MontageOrderBindingModel {
    private String isAircProductChanged;


    public EditMontageOrderBindingModel() {
    }

    public String getIsAircProductChanged() {
        return this.isAircProductChanged;
    }

    public void setIsAircProductChanged(String aircProductChanged) {
        this.isAircProductChanged = aircProductChanged;
    }
}
