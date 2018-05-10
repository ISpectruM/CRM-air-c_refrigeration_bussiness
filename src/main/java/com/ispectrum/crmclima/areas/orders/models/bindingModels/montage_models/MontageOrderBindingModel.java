package com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseBindingModel;
import com.ispectrum.crmclima.constants.Messages;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class MontageOrderBindingModel extends BaseBindingModel{

//montage
    private String productType;

    //repair, prophylactic
    private String product;


    //montage
    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;
//montage
    private Double discount;

//montage
    private String other;


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
}
