package com.ispectrum.crmclima.areas.orders.models.bindingModels;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class MontageOrderBindingModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private String montageType;

    private String product;

    private String productType;

    private Integer count;

    private String city;

    private String address;

    private Double price;

    private Double deposit;

    private Double discount;

    private String comments;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheduleDate;

    private boolean isMarked;
    private boolean isFinished;
    private boolean isForFinishing;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;

    public MontageOrderBindingModel() {
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

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public boolean isMarked() {
        return this.isMarked;
    }

    public void setIsMarked(boolean marked) {
        this.isMarked = marked;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean finished) {
        this.isFinished = finished;
    }

    public boolean isWithInvoice() {
        return this.isWithInvoice;
    }

    public void setIsWithInvoice(boolean withInvoice) {
        this.isWithInvoice = withInvoice;
    }

    public boolean isPayed() {
        return this.isPayed;
    }

    public void setIsPayed(boolean payed) {
        this.isPayed = payed;
    }

    public boolean isDeferred() {
        return this.isDeferred;
    }

    public void setIsDeferred(boolean deferred) {
        this.isDeferred = deferred;
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void setIsWaiting(boolean waiting) {
        this.isWaiting = waiting;
    }

    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isForFinishing() {
        return this.isForFinishing;
    }

    public void setForFinishing(boolean forFinishing) {
        isForFinishing = forFinishing;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
