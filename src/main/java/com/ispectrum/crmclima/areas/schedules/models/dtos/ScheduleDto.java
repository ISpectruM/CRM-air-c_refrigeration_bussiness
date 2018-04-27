package com.ispectrum.crmclima.areas.schedules.models.dtos;


import java.time.LocalDate;
import java.util.Set;

public class ScheduleDto {
    private String id;

    private LocalDate scheduleDate;

    private Set<CreateScheduleDto> montageOrders;

    private Set<CreateScheduleDto> repairOrders;

    private Set<CreateScheduleDto> prophylacticOrders;

    private Integer montagesAmount;
    private Integer repairsAmount;
    private Integer prophylacticsAmount;


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

    public Set<CreateScheduleDto> getMontageOrders() {
        return this.montageOrders;
    }

    public void setMontageOrders(Set<CreateScheduleDto> montageOrders) {
        this.montageOrders = montageOrders;
    }

    public Set<CreateScheduleDto> getRepairOrders() {
        return this.repairOrders;
    }

    public void setRepairOrders(Set<CreateScheduleDto> repairOrders) {
        this.repairOrders = repairOrders;
    }

    public Set<CreateScheduleDto> getProphylacticOrders() {
        return this.prophylacticOrders;
    }

    public void setProphylacticOrders(Set<CreateScheduleDto> prophylacticOrders) {
        this.prophylacticOrders = prophylacticOrders;
    }

    public Integer getMontagesAmount() {
        return this.montagesAmount;
    }

    public void setMontagesAmount(Integer montagesAmount) {
        this.montagesAmount = montagesAmount;
    }

    public Integer getRepairsAmount() {
        return this.repairsAmount;
    }

    public void setRepairsAmount(Integer repairsAmount) {
        this.repairsAmount = repairsAmount;
    }

    public Integer getProphylacticsAmount() {
        return this.prophylacticsAmount;
    }

    public void setProphylacticsAmount(Integer prophylacticsAmount) {
        this.prophylacticsAmount = prophylacticsAmount;
    }
}
