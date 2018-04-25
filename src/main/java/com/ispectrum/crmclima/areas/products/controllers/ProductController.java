package com.ispectrum.crmclima.areas.products.controllers;

import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/airconds")
public class ProductController {
    private final AirConditionService airConditionService;

    @Autowired
    public ProductController(AirConditionService airConditionService) {
        this.airConditionService = airConditionService;
    }

}
