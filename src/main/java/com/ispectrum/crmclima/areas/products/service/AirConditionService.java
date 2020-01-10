package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;
import com.ispectrum.crmclima.areas.products.models.bindingmodels.IndoorUnitBindingModel;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirConditionService {
    Page<AirConditionerDto> getAllAirConditioners(Pageable pageable);
    AirConditioner getByModel(String model);
    String createIndoorUnit(IndoorUnitBindingModel model);
}
