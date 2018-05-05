package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;

import java.time.LocalDate;


public class RepairOrderDto {

    private String id;

    private LocalDate orderDate;

    private RepairType repairType;

    private String product;

    private Integer count;

    private ClientDto client;

    private LocationDto location;

    private Double price;

    private Double deposit;

    private Double forPayment;

    private boolean isFinished;

    private boolean isWaiting;

    private boolean isForFinishing;

    private boolean isWithInvoice;

    private boolean isPayed;

    private String comment;

    private LocalDate scheduleDate;

    private String status;


    public RepairOrderDto() {
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public ClientDto getClient() {
        return this.client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public LocationDto getLocation() {
        return this.location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean getIsWaiting() {
        return this.isWaiting;
    }

    public void setIsWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsForFinishing() {
        return this.isForFinishing;
    }

    public void setIsForFinishing(boolean forFinishing) {
        isForFinishing = forFinishing;
    }

    public boolean getIsWithInvoice() {
        return this.isWithInvoice;
    }

    public void setIsWithInvoice(boolean withInvoice) {
        isWithInvoice = withInvoice;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getForPayment() {
        return this.forPayment;
    }

    public void setForPayment(Double forPayment) {
        this.forPayment = forPayment;
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }

    public void setIsPayed(boolean payed) {
        isPayed = payed;
    }
}
