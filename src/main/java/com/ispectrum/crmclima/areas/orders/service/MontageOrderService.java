package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.orders.models.MontageViewModel;

public interface MontageOrderService {
    MontageViewModel getViewModel(String clientId);
}
