package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseBindingModel;
import com.ispectrum.crmclima.constants.Messages;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class MontageOrderBindingModel extends BaseBindingModel{

    private String productType;

    private String product;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;

    private Double discount;

    private String other;

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

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
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
}
