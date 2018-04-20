package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.models.MontageViewModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;

import java.util.Set;

public interface MontageOrderService {
    MontageViewModel getViewModel(String clientId);

    void addMontage(String clientId,MontageOrderBindingModel model);

    Set<MontageOrderDto> getAllMontages();
}
