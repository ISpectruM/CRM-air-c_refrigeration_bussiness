package com.ispectrum.crmclima.areas.clients.entities;

import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String name;

    @ManyToOne(targetEntity = Location.class)
    private Location location;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "client")
    private Set<MontageOrder> montageOrders;

    @OneToMany(mappedBy = "client")
    private Set<RepairOrder> repairOrders;

    @OneToMany(mappedBy = "client")
    private Set<ProphylacticOrder> prophylacticOrders;


    public Client() {
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

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Set<MontageOrder> getMontageOrders() {
        return this.montageOrders;
    }

    public void setMontageOrders(Set<MontageOrder> montageOrders) {
        this.montageOrders = montageOrders;
    }

    public Set<RepairOrder> getRepairOrders() {
        return this.repairOrders;
    }

    public void setRepairOrders(Set<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

    public Set<ProphylacticOrder> getProphylacticOrders() {
        return this.prophylacticOrders;
    }

    public void setProphylacticOrders(Set<ProphylacticOrder> prophylacticOrders) {
        this.prophylacticOrders = prophylacticOrders;
    }
}
