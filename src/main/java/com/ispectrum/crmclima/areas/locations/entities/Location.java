package com.ispectrum.crmclima.areas.locations.entities;

import com.ispectrum.crmclima.areas.locations.entities.enums.Cities;
import com.ispectrum.crmclima.audit.Audit;
import com.ispectrum.crmclima.audit.AuditListener;
import com.ispectrum.crmclima.audit.Auditable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@EntityListeners(AuditListener.class)
public class Location implements Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cities city;

    private String address;

    private String details;

    private Double lat;

    private Double lng;

    @Embedded
    private Audit audit;

    public Location() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit auditAttributes) {
        this.audit = auditAttributes;
    }
}
