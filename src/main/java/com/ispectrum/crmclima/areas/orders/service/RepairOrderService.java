package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RepairOrderService {

    void saveRepairChanges(OrderSaveModel model);

    List<RepairOrder> getUnfinishedRepairs();

    Set<RepairOrder> getRepairsByDate(LocalDate scheduleDate);
}
