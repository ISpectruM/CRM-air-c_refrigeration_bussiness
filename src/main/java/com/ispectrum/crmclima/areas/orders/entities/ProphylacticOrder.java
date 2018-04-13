package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProphylacticOrder extends BaseOrder{

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @OneToOne
    private Location location;

    @Enumerated
    private RepairType repairType;

    private String product;

    private String comments;


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

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }
}
