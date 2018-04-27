package com.ispectrum.crmclima.areas.products.service;

import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.repository.AirConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirConditionServiceImpl implements AirConditionService {
    private final AirConditionRepository airConditionRepository;

    @Autowired
    public AirConditionServiceImpl(AirConditionRepository airConditionRepository) {
        this.airConditionRepository = airConditionRepository;
    }

    @Override
    public AirConditioner getByModel(String model) {
        return this.airConditionRepository.findFirstByModel(model);
    }
}
