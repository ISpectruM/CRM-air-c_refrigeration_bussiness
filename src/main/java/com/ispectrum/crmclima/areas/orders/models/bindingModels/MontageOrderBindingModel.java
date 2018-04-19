package com.ispectrum.crmclima.areas.orders.models.bindingModels;

import java.time.LocalDate;

public class MontageOrderBindingModel {

    private LocalDate orderDate;

    private Integer count;

    private String comment;

    private String shift;

    private String montageType;

    private Double price;

    private Double deposit;

    private Double discount;

    private Double forPayment;

    private LocalDate scheduleDate;

    private LocalDate endDate;

    private boolean isMarked;
    private boolean isFinished;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;

    public MontageOrderBindingModel() {
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
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

    public Double getForPayment() {
        return this.forPayment;
    }

    public void setForPayment(Double forPayment) {
        this.forPayment = forPayment;
    }

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isMarked() {
        return this.isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isWithInvoice() {
        return this.isWithInvoice;
    }

    public void setWithInvoice(boolean withInvoice) {
        isWithInvoice = withInvoice;
    }

    public boolean isPayed() {
        return this.isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean isDeferred() {
        return this.isDeferred;
    }

    public void setDeferred(boolean deferred) {
        isDeferred = deferred;
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }

    public String getShift() {
        return this.shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
