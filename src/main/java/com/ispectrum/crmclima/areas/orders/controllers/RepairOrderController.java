package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/orders/repairs")
public class RepairOrderController extends BaseController{
    private final RepairOrderService repairOrderService;
    private final ClientService clientService;

    @Autowired
    public RepairOrderController(RepairOrderService repairOrderService, ClientService clientService) {
        this.repairOrderService = repairOrderService;
        this.clientService = clientService;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addRepair(@PathVariable String id){
        ClientDto clientById = this.clientService.getClientById(id);
        this.addViewAndObject("client",clientById,"orders/repairs/add");
        this.addObject("bindingModel", new RepairBindingModel());

        return this.addObject("currentDate", LocalDate.now());
    }

    @PostMapping("/add/{id}")
    public ModelAndView addRepairAction(
            @PathVariable String id,
            @Valid @ModelAttribute(name = "bindingModel") RepairBindingModel bindingModel,
            BindingResult bindingResult){

        ClientDto clientById = this.clientService.getClientById(id);
        if (bindingResult.hasErrors()){
            Map<String, Object> bindingResultModel = bindingResult.getModel();
            bindingResultModel.put("client", clientById);
            return this.addViewAndObjectsMap("orders/repairs/add", bindingResultModel);
        }

        this.repairOrderService.saveRepairOrder(id,bindingModel);
        return this.redirect("/orders/repairs/all?page=0");
    }
}
