package com.ispectrum.crmclima.areas.users.entities;

import com.ispectrum.crmclima.audit.Audit;
import com.ispectrum.crmclima.audit.AuditListener;
import com.ispectrum.crmclima.audit.Auditable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@EntityListeners(AuditListener.class)
public class Role implements GrantedAuthority, Auditable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String authority;

    @Embedded
    private Audit audit;


    public Role() {
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
