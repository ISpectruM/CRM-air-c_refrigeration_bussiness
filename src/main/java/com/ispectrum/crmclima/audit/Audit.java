package com.ispectrum.crmclima.audit;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    @Column(name = "updated_by")
    private String updatedBy;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdAt) {
        this.createdOn = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedAt) {
        this.updatedOn = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
