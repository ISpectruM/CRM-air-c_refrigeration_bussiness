package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.entities.enums.Shift;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;

import javax.persistence.*;
import java.util.*;

@Entity
public class MontageOrder extends BaseOrder{

    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @Enumerated(EnumType.STRING)
    private MontageType montageType;

    @ElementCollection(targetClass = java.lang.Integer.class)
//    @ManyToMany(targetEntity = AirConditioner.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "montages_conditioners_count",
            joinColumns = @JoinColumn(name = "morder_id")
            )
    @MapKeyColumn(name = "airc_type")
    @Column(name = "count")
    private Map<AirConditioner,Integer> airConditioners;


    public MontageOrder() {
        this.airConditioners = new HashMap<>();
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

    public Map<AirConditioner, Integer> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Map<AirConditioner, Integer> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }

    @Override
    public Integer getCount() {
        int count = 0;
        Collection<Integer> values = this.getAirConditioners().values();
        if(!values.isEmpty()){
         count = values.stream().mapToInt(Number::intValue).sum();
        }
        return count;
    }
}
