package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;

public interface AirConditionService {
    AirConditioner getByModel(String model);
}
