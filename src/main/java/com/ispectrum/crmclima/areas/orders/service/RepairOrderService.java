package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;

import java.util.List;

public interface RepairOrderService {

    void saveRepairChanges(OrderSaveModel model);

    List<RepairOrder> getUnfinishedRepairs();
}
