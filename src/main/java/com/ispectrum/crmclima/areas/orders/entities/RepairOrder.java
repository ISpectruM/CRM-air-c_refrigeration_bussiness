package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;

import javax.persistence.*;

@Entity
public class RepairOrder extends BaseOrder{

    private final String service = "repair";

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @Enumerated(EnumType.STRING)
    private RepairType repairType;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;


    public RepairOrder() {
    }


    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public String getService() {
        return this.service;
    }
}
