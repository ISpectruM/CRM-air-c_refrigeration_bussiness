package com.ispectrum.crmclima.areas.products.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;
import com.ispectrum.crmclima.areas.products.models.bindingmodels.IndoorUnitBindingModel;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/products/airconditioners")
public class AirConditionersController extends BaseController {

    private AirConditionService airConditionService;

    @Autowired
    public AirConditionersController(AirConditionService airConditionService) {
        this.airConditionService = airConditionService;
    }

    /**
     * Air-conditioners endpoints
     */
    @GetMapping("/all")
    public ModelAndView getAllAirConditioners(
            @PageableDefault(sort = {"brand"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<AirConditionerDto> allAirConditioners = this.airConditionService.getAllAirConditioners(pageable);
        this.addViewAndObject("objects", allAirConditioners, "/products/airconditioners/all");
        return this.addObjectToView("area", "products/airconditioners");
    }

    @GetMapping("/add")
    public ModelAndView createAirConditioner() {
        return null; //TODO
    }

    @PostMapping("/add")
    public ModelAndView createAirConditionerAction() {
        return null;//TODO
    }

    @GetMapping("/details/{id}")
    public ModelAndView getAirConditionerDetails(@PathVariable String id) {
        return null;//TODO
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAirConditioner(@PathVariable String id) {
        return null;//TODO
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editAirConditionerAction(@PathVariable String id) {
        return null;//TODO
    }

    /**
     * Indoor unit endpoints
     */
    @GetMapping("/indoor/all")
    public ModelAndView getAllIndoorUnits() {
        return null;//TODO
    }

    @GetMapping("/indoor/add")
    public ModelAndView createIndoorUnit() {
        return this.addViewAndObject(
                "currentDate",
                LocalDate.now(),
                "products/airconditioners/indoor_units/add_indoor_unit");
    }

    @PostMapping("/indoor/add")
    public ModelAndView createIndoorUnitAction(@RequestBody IndoorUnitBindingModel model) {
        return null;//TODO
    }

    @GetMapping("/indoor/details/{id}")
    public ModelAndView getIndoorUnitDetails(@PathVariable String id) {
        return null;//TODO
    }

    @GetMapping("/indoor/edit/{id}")
    public ModelAndView editIndoorUnit(@PathVariable String id) {
        return null;//TODO
    }

    @PostMapping("/indoor/edit/{id}")
    public ModelAndView editIndoorUnitAction(@PathVariable String id) {
        return null;//TODO
    }

    /**
     * OutDoor units endpoints
     */
    @GetMapping("/outdoor/all")
    public ModelAndView getAllOutDoorUnits() {
        return null;//TODO
    }

    @GetMapping("/outdoor/add")
    public ModelAndView createOutdoorUnit() {
        return null;//TODO
    }

    @PostMapping("/outdoor/add")
    public ModelAndView createOutdoorUnitAction() {
        return null;//TODO
    }

    @GetMapping("/outdoor/details/{id}")
    public ModelAndView getOutdoorUnitDetails(@PathVariable String id) {
        return null;//TODO
    }

    @GetMapping("/outdoor/edit/{id}")
    public ModelAndView editOutdoorUnit(@PathVariable String id) {
        return null;//TODO
    }

    @PostMapping("/outdoor/edit/{id}")
    public ModelAndView editOutdoorUnitAction(@PathVariable String id) {
        return null;//TODO
    }
}
