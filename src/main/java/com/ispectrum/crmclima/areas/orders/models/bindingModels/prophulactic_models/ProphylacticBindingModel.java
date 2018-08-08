package com.ispectrum.crmclima.areas.orders.models.bindingModels.prophulactic_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.constants.Messages;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProphylacticBindingModel extends BaseOrderBindingModel {

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String prophylacticType;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double price;

    private String otherProduct;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    @NotNull(message = Messages.FIELD_CANT_BE_EMPTY)
    private Integer count;

    public ProphylacticBindingModel() {
    }


    public String getProphylacticType() {
        return prophylacticType;
    }

    public void setProphylacticType(String prophylacticType) {
        this.prophylacticType = prophylacticType;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getOtherProduct() {
        return otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
