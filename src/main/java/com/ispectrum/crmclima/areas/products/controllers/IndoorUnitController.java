package com.ispectrum.crmclima.areas.products.controllers;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.IndoorUnit;
import com.ispectrum.crmclima.areas.products.models.bindingmodels.IndoorUnitBindingModel;
import com.ispectrum.crmclima.areas.products.models.dtos.IndoorUnitDTO;
import com.ispectrum.crmclima.areas.products.service.IndoorUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/products/indoors")
public class IndoorUnitController extends BaseController {

    private IndoorUnitService indoorUnitService;

    @Autowired
    public IndoorUnitController(IndoorUnitService indoorUnitService) {
        this.indoorUnitService = indoorUnitService;
    }

    /**
     * Indoor unit endpoints
     */
    @GetMapping("/all")
    public ModelAndView getAllIndoorUnits(
            @PageableDefault(sort = {"brand"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<IndoorUnit> allIndoorUnits = this.indoorUnitService.listAllAvailableIndoors(pageable);
        Page<IndoorUnitDTO> indoorUnitDTOS = ModelMappingUtil.convertPage(allIndoorUnits, IndoorUnitDTO.class);

        this.addViewAndObject("objects", indoorUnitDTOS, "/products/airconditioners/all");
        //Set pagination buttons url
        this.addObjectToView("area", "products/indoors");

        return this.addObjectToView("productType", "indoors");
    }

    @GetMapping("/add")
    public ModelAndView createIndoorUnit(@ModelAttribute("indoorUnitBindingModel") IndoorUnitBindingModel indoorUnitBindingModel) {
        return this.setView("products/airconditioners/indoor_units/add_indoor_unit");
    }

    @PostMapping("/add")
    public ModelAndView createIndoorUnitAction(
            @Valid @ModelAttribute(name = "indoorUnitBindingModel") IndoorUnitBindingModel model,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, Object> bindingResultModel = bindingResult.getModel();
            return this.addViewAndObjectsMap("products/airconditioners/indoor_units/add_indoor_unit", bindingResultModel);
        }
        IndoorUnit indoorUnit = ModelMappingUtil.convertClass(model, IndoorUnit.class);
        indoorUnitService.createIndoorUnit(indoorUnit);
        return this.redirect("/products/indoors/all?page=0");
    }

    @GetMapping("/details/{id}")
    public ModelAndView getIndoorUnitDetails(@PathVariable String id) {
        IndoorUnit indoorById = indoorUnitService.getIndoorById(id);
        IndoorUnitDTO indoorUnitDTO = ModelMappingUtil.convertClass(indoorById, IndoorUnitDTO.class);
        this.addViewAndObject("unit", indoorUnitDTO, "products/airconditioners/details");

        return this.addObjectToView("productType", "indoors");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editIndoorUnit(@PathVariable String id) {
        IndoorUnit indoorUnit = this.indoorUnitService.getIndoorById(id);
        IndoorUnitBindingModel indoorUnitModel = ModelMappingUtil.convertClass(indoorUnit, IndoorUnitBindingModel.class);

        return this.addViewAndObject("indoorUnitBindingModel", indoorUnitModel, "products/airconditioners/indoor_units/edit_indoor_unit");
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editIndoorUnitAction(
            @PathVariable String id,
            @Valid @ModelAttribute(name = "indoorUnitBindingModel") IndoorUnitBindingModel model,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, Object> bindingResultModel = bindingResult.getModel();
            this.addViewAndObjectsMap("products/airconditioners/indoor_units/edit_indoor_unit", bindingResultModel);
            return this.addObjectToView("unit", model);
        }
        IndoorUnit indoorUnit = ModelMappingUtil.convertClass(model, IndoorUnit.class);
        indoorUnitService.editInDoorUnit(id, indoorUnit);
        return this.redirect("/products/indoors/details/" + id);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteIndoorUnit(@PathVariable String id) {
        IndoorUnit indoorUnit = this.indoorUnitService.getIndoorById(id);
        IndoorUnitDTO indoorUnitModel = ModelMappingUtil.convertClass(indoorUnit, IndoorUnitDTO.class);

        return this.addViewAndObject("indoorUnitBindingModel", indoorUnitModel, "products/airconditioners/indoor_units/delete_indoor_unit");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteIndoorUnitAction(
            @PathVariable String id) {

        this.indoorUnitService.deleteIndoor(id);
        return this.redirect("/products/indoors/all?page=0");
    }

}
