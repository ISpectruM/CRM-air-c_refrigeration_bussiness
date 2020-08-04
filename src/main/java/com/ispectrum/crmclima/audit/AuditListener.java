package com.ispectrum.crmclima.audit;

import com.ispectrum.crmclima.Utils.UserUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Object auditable) {
        Audit audit = ((Auditable) auditable).getAudit();

        if (audit == null) {
            audit = new Audit();
            ((Auditable) auditable).setAudit(audit);
        }

        audit.setCreatedOn(LocalDateTime.now());
        audit.setCreatedBy(UserUtils.getCurrentUserName());
    }

    @PreUpdate
    public void setUpdatedOn(Object auditable) {
        Audit audit = ((Auditable) auditable).getAudit();

        audit.setUpdatedOn(LocalDateTime.now());
        audit.setUpdatedBy(UserUtils.getCurrentUserName());
    }
}
