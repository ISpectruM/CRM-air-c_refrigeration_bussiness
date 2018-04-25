package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.enums.ProphylacticType;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;

import javax.persistence.*;

@Entity
public class ProphylacticOrder extends BaseOrder{

    private final String service = "prophylactic";

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @Enumerated(EnumType.STRING)
    private ProphylacticType prophylacticType;

    @OneToOne
    private Location location;

    private String product;


    public ProphylacticOrder() { }


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

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public ProphylacticType getProphylacticType() {
        return this.prophylacticType;
    }

    public void setProphylacticType(ProphylacticType prophylacticType) {
        this.prophylacticType = prophylacticType;
    }

    public String getService() {
        return this.service;
    }
}
