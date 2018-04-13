package com.ispectrum.crmclima.areas.schedules.entities;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @OneToMany(targetEntity = MontageOrder.class)
    private Set<MontageOrder> montageOrders;

    @OneToMany(targetEntity = RepairOrder.class)
    private Set<RepairOrder> repairOrders;

    @OneToMany(targetEntity = ProphylacticOrder.class)
    private Set<ProphylacticOrder> prophylacticOrders;

    public Schedule() {
        this.montageOrders = new HashSet<>();
        this.repairOrders = new HashSet<>();
        this.prophylacticOrders = new HashSet<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
