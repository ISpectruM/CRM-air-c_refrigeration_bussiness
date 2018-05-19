package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.constants.Messages;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class MontageOrderBindingModel extends BaseOrderBindingModel {

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String montageType;

    private String productType;

    private String otherProduct;

    private String model;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double discount;

    private List<String> aircProductsBin;
    private List<String> coolersProductsBin;
    private List<String> fridgeProductsBin;

    public MontageOrderBindingModel() {
    }

    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProduct() {
        return this.model;
    }

    public void setProduct(String product) {
        this.model = product;
    }

    public List<String> getAircProductsBin() {
        return this.aircProductsBin;
    }

    public void setAircProductsBin(List<String> aircProductsBin) {
        this.aircProductsBin = aircProductsBin;
    }

    public List<String> getCoolersProductsBin() {
        return this.coolersProductsBin;
    }

    public void setCoolersProductsBin(List<String> coolersProductsBin) {
        this.coolersProductsBin = coolersProductsBin;
    }

    public List<String> getFridgeProductsBin() {
        return this.fridgeProductsBin;
    }

    public void setFridgeProductsBin(List<String> fridgeProductsBin) {
        this.fridgeProductsBin = fridgeProductsBin;
    }

    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }

    public String getOtherProduct() {
        return this.otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }
}
