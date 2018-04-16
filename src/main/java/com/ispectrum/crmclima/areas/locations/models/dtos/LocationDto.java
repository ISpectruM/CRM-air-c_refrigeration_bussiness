package com.ispectrum.crmclima.areas.locations.models.dtos;

public class LocationDto {

    private String city;

    private String address;

    private String details;

    public LocationDto() {
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
