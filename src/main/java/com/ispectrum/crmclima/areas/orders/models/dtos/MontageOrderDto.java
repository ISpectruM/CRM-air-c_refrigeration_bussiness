package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;

import java.time.LocalDate;
import java.util.Set;

public class MontageOrderDto {

    private String id;

    private LocalDate orderDate;

    private String montageType;

    private Set<AirConditionerDto> airConditioners;

    private ClientDto clientDto;

    private LocationDto locationDto;

    private Double price;

    private Double deposit;

    private boolean isFinished;

    private boolean isWaiting;

    private String comment;

    private LocalDate scheduleDate;

    private LocalDate endDate;



    public MontageOrderDto() {
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getMontageType() {
        return this.montageType;
    }

    public void setMontageType(String montageType) {
        this.montageType = montageType;
    }

    public Set<AirConditionerDto> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Set<AirConditionerDto> airConditioners) {
        this.airConditioners = airConditioners;
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

    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
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

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
