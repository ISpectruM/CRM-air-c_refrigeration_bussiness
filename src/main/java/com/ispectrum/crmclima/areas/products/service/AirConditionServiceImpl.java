package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.IndoorUnit;
import com.ispectrum.crmclima.areas.products.models.bindingmodels.IndoorUnitBindingModel;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;
import com.ispectrum.crmclima.areas.products.repository.AirConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AirConditionServiceImpl implements AirConditionService {
    private final AirConditionRepository airConditionRepository;

    @Autowired
    public AirConditionServiceImpl(AirConditionRepository airConditionRepository) {
        this.airConditionRepository = airConditionRepository;
    }

    @Override
    public Page<AirConditionerDto> getAllAirConditioners(Pageable pageable) {
        Page<AirConditioner> airConditioners = this.airConditionRepository.findAll(pageable);
        return ModelMappingUtil.convertPage(airConditioners, AirConditionerDto.class);
    }

    @Override
    public AirConditioner getByModel(String model) {
        return this.airConditionRepository.findFirstByIndoorUnitModel(model);
    }

}
