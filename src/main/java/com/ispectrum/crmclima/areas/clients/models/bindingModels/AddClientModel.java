package com.ispectrum.crmclima.areas.clients.models.bindingModels;

import com.ispectrum.crmclima.constants.Messages;
import com.ispectrum.crmclima.validation.AtLeastOneFieldNotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AtLeastOneFieldNotNull(fieldNames = {"name","city","address","phone"},
        message = Messages.FILL_AT_LEAST_ONE_FIELD)
public class AddClientModel {

    private String name;

    private String city;

    private String address;

    private String email;

    private String phone;


    public AddClientModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
