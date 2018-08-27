package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;


public class EditMontageOrderBindingModel extends MontageOrderBindingModel {
    private boolean isAircProductChanged;


    public EditMontageOrderBindingModel() {
    }

    public boolean getIsAircProductChanged() {
        return this.isAircProductChanged;
    }

    public void setIsAircProductChanged(boolean aircProductChanged) {
        this.isAircProductChanged = aircProductChanged;
    }
}
