package com.ispectrum.crmclima.areas.schedules.entities;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(unique = true)
    private LocalDate scheduleDate;

    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToMany(targetEntity = MontageOrder.class)
    private Set<MontageOrder> montageOrders;

    @ManyToMany(targetEntity = RepairOrder.class)
    private Set<RepairOrder> repairOrders;

    @ManyToMany(targetEntity = ProphylacticOrder.class)
    private Set<ProphylacticOrder> prophylacticOrders;

    @Transient
    private Integer montagesAmount;
    @Transient
    private Integer repairsAmount;
    @Transient
    private Integer prophylacticsAmount;

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

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Integer getMontagesAmount() {
        return this.montageOrders.size();
    }

    public void setMontagesAmount(Integer montagesAmount) {
        this.montagesAmount = montagesAmount;
    }

    public Integer getRepairsAmount() {
        return this.repairOrders.size();
    }

    public void setRepairsAmount(Integer repairsAmount) {
        this.repairsAmount = repairsAmount;
    }

    public Integer getProphylacticsAmount() {
        return this.prophylacticOrders.size();
    }

    public void setProphylacticsAmount(Integer prophylacticsAmount) {
        this.prophylacticsAmount = prophylacticsAmount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
