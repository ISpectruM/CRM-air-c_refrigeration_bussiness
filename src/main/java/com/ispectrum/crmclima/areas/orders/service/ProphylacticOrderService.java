package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;

import java.util.List;

public interface ProphylacticOrderService {

    void saveProphylacticChanges(OrderSaveModel model);

    List<ProphylacticOrder> getUnfinishedProphylactics();
}
