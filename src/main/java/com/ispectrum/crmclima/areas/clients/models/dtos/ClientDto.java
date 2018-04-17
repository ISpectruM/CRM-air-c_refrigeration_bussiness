package com.ispectrum.crmclima.areas.clients.models.dtos;

import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.dtos.ProphylacticOrderDto;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;

import java.util.Set;

public class ClientDto {
    private String id;

    private String name;

    private String city;

    private String address;

    private String email;

    private String phone;

    private Set<MontageOrderDto> montageOrders;

    private Set<RepairOrderDto> repairOrders;

    private Set<ProphylacticOrderDto> prophylacticOrders;

    public ClientDto() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<MontageOrderDto> getMontageOrders() {
        return this.montageOrders;
    }

    public void setMontageOrders(Set<MontageOrderDto> montageOrders) {
        this.montageOrders = montageOrders;
    }

    public Set<RepairOrderDto> getRepairOrders() {
        return this.repairOrders;
    }

    public void setRepairOrders(Set<RepairOrderDto> repairOrders) {
        this.repairOrders = repairOrders;
    }

    public Set<ProphylacticOrderDto> getProphylacticOrders() {
        return this.prophylacticOrders;
    }

    public void setProphylacticOrders(Set<ProphylacticOrderDto> prophylacticOrders) {
        this.prophylacticOrders = prophylacticOrders;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
