package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RepairOrder extends BaseOrder{

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @OneToOne
    private Location location;

    private String product;

    private String description;


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

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
