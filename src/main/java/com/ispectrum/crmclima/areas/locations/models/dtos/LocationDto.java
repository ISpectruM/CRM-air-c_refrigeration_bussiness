package com.ispectrum.crmclima.areas.locations.models.dtos;

import com.ispectrum.crmclima.areas.locations.entities.enums.Cities;

public class LocationDto {

    private Cities city;

    private String area;

    private String address;

    private String details;

    public LocationDto() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}
