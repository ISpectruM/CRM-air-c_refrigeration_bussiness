package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.entities.enums.Shift;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MontageOrder extends BaseOrder{

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @OneToOne
    private Location location;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Enumerated(EnumType.STRING)
    private MontageType montageType;

    @ManyToMany(targetEntity = AirConditioner.class)
    @JoinTable(
            name = "montages_conditioners",
            joinColumns = @JoinColumn(name = "morder_id"),
            inverseJoinColumns = @JoinColumn(name = "airc_id")
    )
    private Set<AirConditioner> airConditioners;


    public MontageOrder() {
        this.airConditioners = new HashSet<>();
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

    public Shift getShift() {
        return this.shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Set<AirConditioner> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Set<AirConditioner> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }
}
