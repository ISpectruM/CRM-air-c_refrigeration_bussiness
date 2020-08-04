package com.ispectrum.crmclima.audit;

public interface Auditable {
    Audit getAudit();

    void setAudit(Audit audit);
}
