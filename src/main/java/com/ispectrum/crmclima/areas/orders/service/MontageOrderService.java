package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;

import java.util.Set;

public interface MontageOrderService {
    MontageOrderDto getViewModel(String clientId);

    void addMontage(String clientId,MontageOrderBindingModel model);

    Set<MontageOrderDto> getAllMontages();
}
