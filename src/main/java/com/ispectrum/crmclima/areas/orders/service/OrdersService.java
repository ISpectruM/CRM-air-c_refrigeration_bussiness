package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;

import java.util.List;

public interface OrdersService {
    List<MontageOrder> getAllUnfinishedMontages();

    List<RepairOrder> getAllUnfinishedRepairs();

    List<ProphylacticOrder> getAllUnfinishedProphylactics();

    void saveOrder(OrderSaveModel model);
}
