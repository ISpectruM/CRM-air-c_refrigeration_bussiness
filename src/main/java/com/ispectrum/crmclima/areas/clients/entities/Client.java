package com.ispectrum.crmclima.areas.clients.entities;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import org.hibernate.annotations.GenericGenerator;
import org.modelmapper.internal.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private LocalDate enterDate;

    private String name;

    private String city;

    private String address;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "client")
    private Set<MontageOrder> montageOrders;

    @OneToMany(mappedBy = "client")
    private Set<RepairOrder> repairOrders;

    @OneToMany(mappedBy = "client")
    private Set<ProphylacticOrder> prophylacticOrders;


    public Client() {
        this.enterDate = LocalDate.now();
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

    public LocalDate getEnterDate() {
        return this.enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }
}
