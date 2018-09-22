package com.ispectrum.crmclima.areas.orders.models.ajax;

import java.util.Date;

public class RestOrderBindingModel {

    private String id;

    private String type;

    private StatusBindingSaveModel status;

    private Date scheduleDate;

    private String comment;


    public RestOrderBindingModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StatusBindingSaveModel getStatus() {
        return this.status;
    }

    public void setStatus(StatusBindingSaveModel status) {
        this.status = status;
    }

    public Date getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
