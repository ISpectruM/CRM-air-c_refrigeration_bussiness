package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;

import java.util.List;
import java.util.Set;

public interface MontageOrderService {

    void addMontage(String clientId,MontageOrderBindingModel model);

    List<MontageOrderDto> getAllMontages();

    MontageOrderDto getMontageById(String id);

    void deleteOrder(String id);

    void editMontage(String id,MontageOrderBindingModel model);

    Set<MontageOrderDto> getAllUnfinishedOrders();
}
