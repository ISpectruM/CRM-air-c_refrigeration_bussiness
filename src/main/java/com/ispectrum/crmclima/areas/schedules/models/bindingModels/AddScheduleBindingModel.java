package com.ispectrum.crmclima.areas.schedules.models.bindingModels;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddScheduleBindingModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheduleDate;

    public AddScheduleBindingModel() {
    }


    public Date getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
