package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ScheduleOrdersMediatorService {
    List<MontageOrder> getAllUnfinishedMontages();

    List<RepairOrder> getAllUnfinishedRepairs();

    List<ProphylacticOrder> getAllUnfinishedProphylactics();

    void saveOrder(RestOrderBindingModel model);

    Set<MontageOrder> getMontagesByScheduleDate(LocalDate scheduleDate);

    Set<RepairOrder> getRepairsByScheduleDate(LocalDate scheduleDate);

    Set<ProphylacticOrder> getProphylacticsByScheduleDate(LocalDate scheduleDate);
}
