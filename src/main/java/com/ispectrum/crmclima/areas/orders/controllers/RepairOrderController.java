package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.repair_models.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;
import com.ispectrum.crmclima.areas.orders.service.RepairOrderService;
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

    @PostMapping("/add/{clientId}")
    public ModelAndView addRepairAction(
            @PathVariable String clientId,
            @Valid @ModelAttribute(name = "bindingModel") RepairBindingModel bindingModel,
            BindingResult bindingResult){

        ClientDto clientById = this.clientService.getClientById(clientId);
        if (bindingResult.hasErrors()){
            Map<String, Object> bindingResultModel = bindingResult.getModel();
            bindingResultModel.put("client", clientById);
            return this.addViewAndObjectsMap("orders/repairs/add", bindingResultModel);
        }

        this.repairOrderService.saveRepairOrder(clientId,bindingModel);
        return this.redirect("/orders/repairs/all?page=0");
    }

    @GetMapping("/all")
    public ModelAndView getAllRepairs(
            @PageableDefault(sort={"orderDate"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<RepairOrderDto> allRepairs = this.repairOrderService.getAllRepairs(pageable);
        this.addViewAndObject("objects",allRepairs,"orders/repairs/all");
        return this.addObject("area", "repairs");
    }

    @GetMapping("/details/{id}")
    public ModelAndView getRepairDetails(@PathVariable String id){
        RepairOrderDto repair = this.repairOrderService.getRepairById(id);

        return this.addViewAndObject("order",repair,"orders/details");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editRepair(@PathVariable String id){
        RepairOrderDto repair = this.repairOrderService.getRepairById(id);
        this.addViewAndObject("repair", repair,"orders/repairs/edit");
        return this.addObject("bindingModel", new RepairBindingModel());
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editOrderAction(@PathVariable String id,
                                        RepairBindingModel model){
        this.repairOrderService.editRepair(id,model);
        return this.redirect("/orders/repairs/details/" + id);
    }

    @GetMapping("/delete/{repairId}")
    public ModelAndView deleteOrder(@PathVariable String repairId){
        RepairOrderDto montage = this.repairOrderService.getRepairById(repairId);
        return this.addViewAndObject("repair", montage,"orders/repairs/delete");
    }

    @PostMapping("/delete/{repairId}")
    public ModelAndView deleteOrderAction(@PathVariable String repairId){
        this.repairOrderService.deleteRepair(repairId);
        return this.redirect("/orders/repairs/all?page=0");
    }
}
