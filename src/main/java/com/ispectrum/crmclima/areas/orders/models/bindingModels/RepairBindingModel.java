package com.ispectrum.crmclima.areas.orders.models.bindingModels;

import com.ispectrum.crmclima.constants.Messages;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RepairBindingModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    @NotEmpty(message = Messages.CHOOSE_SERVICE)
    private String repairType;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    @NotNull(message = Messages.FIELD_CANT_BE_EMPTY)
    private Integer count;

    @NotEmpty(message = Messages.FIELD_CANT_BE_EMPTY)
    private String city;

    private String address;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double price;

    @Min(value = 0, message = Messages.NEGATIVE_NUMBERS_NOT_ALLOWED)
    private Double deposit;

    private Double discount;

    private String comment;

    private String Description;

    private String otherProduct;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheduleDate;

    private boolean isMarked;
    private boolean isFinished;
    private boolean isForFinishing;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;

    public RepairBindingModel() {
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Date getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(boolean marked) {
        this.isMarked = marked;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean finished) {
        this.isFinished = finished;
    }

    public boolean getIsWithInvoice() {
        return this.isWithInvoice;
    }

    public void setIsWithInvoice(boolean withInvoice) {
        this.isWithInvoice = withInvoice;
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }

    public void setIsPayed(boolean payed) {
        this.isPayed = payed;
    }

    public boolean getIsDeferred() {
        return this.isDeferred;
    }

    public void setIsDeferred(boolean deferred) {
        this.isDeferred = deferred;
    }

    public boolean getIsWaiting() {
        return this.isWaiting;
    }

    public void setIsWaiting(boolean waiting) {
        this.isWaiting = waiting;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsForFinishing() {
        return this.isForFinishing;
    }

    public void setIsForFinishing(boolean forFinishing) {
        isForFinishing = forFinishing;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
