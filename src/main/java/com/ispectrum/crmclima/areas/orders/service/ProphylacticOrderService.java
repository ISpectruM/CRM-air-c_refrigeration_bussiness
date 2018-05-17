package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.entities.ProphylacticOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProphylacticOrderService {

    void saveProphylacticChanges(RestOrderBindingModel model);

    List<ProphylacticOrder> getUnfinishedProphylactics();

    Set<ProphylacticOrder> getProphylacticsByDate(LocalDate scheduleDate);
}
