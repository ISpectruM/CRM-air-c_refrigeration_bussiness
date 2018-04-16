package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;

import java.time.LocalDate;


public class RepairOrderDto {

    private String id;

    private LocalDate orderDate;

    private String repairType;

    private String product;

    private Integer count;

    private ClientDto clientDto;

    private LocationDto locationDto;

    private Double price;

    private boolean isFinished;

    private boolean isWaiting;

    private String comment;

    private LocalDate scheduleDate;

    private LocalDate endDate;

    public RepairOrderDto() {
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getRepairType() {
        return this.repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public ClientDto getClientDto() {
        return this.clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public LocationDto getLocationDto() {
        return this.locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void setWaiting(boolean waiting) {
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

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
}
