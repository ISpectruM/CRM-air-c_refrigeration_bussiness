package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;
import java.time.LocalDate;

public class ProphylacticOrderDto {

    private String id;

    private LocalDate orderDate;

    private String prophylacticType;

    private String product;

    private ClientDto clientDto;

    private LocationDto locationDto;

    private boolean isFinished;

    private boolean isWaiting;

    private LocalDate scheduleDate;

    private LocalDate endDate;

    public ProphylacticOrderDto() {
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProphylacticType() {
        return this.prophylacticType;
    }

    public void setProphylacticType(String prophylacticType) {
        this.prophylacticType = prophylacticType;
    }
}
