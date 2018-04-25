package com.ispectrum.crmclima.areas.schedules.models.dtos;

import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.dtos.ProphylacticOrderDto;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;

import java.time.LocalDate;
import java.util.Set;

public class ScheduleDto {
    private String id;

    private LocalDate scheduleDate;

    private Set<ScheduleDto> montageOrders;

    private Set<ScheduleDto> repairOrders;

    private Set<ScheduleDto> prophylacticOrders;


    public ScheduleDto() {
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Set<ScheduleDto> getMontageOrders() {
        return this.montageOrders;
    }

    public void setMontageOrders(Set<ScheduleDto> montageOrders) {
        this.montageOrders = montageOrders;
    }

    public Set<ScheduleDto> getRepairOrders() {
        return this.repairOrders;
    }

    public void setRepairOrders(Set<ScheduleDto> repairOrders) {
        this.repairOrders = repairOrders;
    }

    public Set<ScheduleDto> getProphylacticOrders() {
        return this.prophylacticOrders;
    }

    public void setProphylacticOrders(Set<ScheduleDto> prophylacticOrders) {
        this.prophylacticOrders = prophylacticOrders;
    }
}
