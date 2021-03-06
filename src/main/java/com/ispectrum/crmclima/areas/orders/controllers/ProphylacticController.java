package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.prophulactic_models.ProphylacticBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.ProphylacticOrderDto;
import com.ispectrum.crmclima.areas.orders.service.ProphylacticOrderService;
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
@RequestMapping("/orders/prophylactics")
public class ProphylacticController extends BaseController {

    private ProphylacticOrderService prophylacticOrderService;

    private ClientService clientService;

    @Autowired
    public ProphylacticController(ProphylacticOrderService prophylacticOrderService, ClientService clientService) {
        this.prophylacticOrderService = prophylacticOrderService;
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ModelAndView getAll(
            @PageableDefault(sort = {"orderNumber"},
                    direction = Sort.Direction.DESC) Pageable pageable){
        Page<ProphylacticOrderDto> prophylactics =
                this.prophylacticOrderService.getAllProphylactics(pageable);
        this.addViewAndObject("objects", prophylactics, "orders/prophylactics/all");
//      Needed for setting a proper OrderType paging navigation at templates/fragments/page_nav
        return this.addObjectToView("area", "orders/prophylactics");
    }

    @GetMapping("/add/{clientId}")
    public ModelAndView addProphylactic(@PathVariable String clientId){
        ClientDto clientDto = this.clientService.getClientById(clientId);

        this.setView("orders/prophylactics/add");
        this.addObjectToView("client", clientDto);
        this.addObjectToView("currentDate", LocalDate.now());
        return this.addObjectToView("bindingModel", new ProphylacticBindingModel());
    }

    @PostMapping("/add/{clientId}")
    public ModelAndView addProphylacticAction(
            @PathVariable String clientId,
            @Valid @ModelAttribute(name = "bindingModel") ProphylacticBindingModel bindingModel,
            BindingResult bindingResult){

        ClientDto clientById = this.clientService.getClientById(clientId);
        if (bindingResult.hasErrors()){
            Map<String, Object> bindingResultModel = bindingResult.getModel();
            bindingResultModel.put("client", clientById);
            bindingResultModel.put("currentDate", LocalDate.now());
            return this.addViewAndObjectsMap("orders/prophylactics/add", bindingResultModel);
        }

        this.prophylacticOrderService.createProphylactic(clientId,bindingModel);
        return this.redirect("/orders/prophylactics/all?page=0");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProphylactic(@PathVariable String id){
        ProphylacticOrderDto prophylacticById = this.prophylacticOrderService.getProphylacticById(id);
        this.addViewAndObject("prophylactic",prophylacticById, "orders/prophylactics/edit");
        return this.addObjectToView("bindingModel", new ProphylacticBindingModel());
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProphylacticAction(
            @PathVariable String id,
            @Valid @ModelAttribute ProphylacticBindingModel bindingModel,
            BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, Object> model = bindingResult.getModel();
            model.put("currentDate", LocalDate.now());
            return this.addViewAndObjectsMap("orders/prophylactics/edit", model);
        }

        this.prophylacticOrderService.editProphylactic(id, bindingModel);
        return this.redirect("/orders/prophylactics/details/" + id);
    }

    @GetMapping("/details/{orderId}")
    public ModelAndView getDetails(@PathVariable String orderId){
        ProphylacticOrderDto prophylacticById = this.prophylacticOrderService.getProphylacticById(orderId);
        return this.addViewAndObject("order", prophylacticById, "orders/details");
    }

    @GetMapping("delete/{orderId}")
    public ModelAndView delete(@PathVariable String orderId){
        ProphylacticOrderDto prophylactic = this.prophylacticOrderService.getProphylacticById(orderId);
        return this.addViewAndObject("order", prophylactic, "orders/prophylactics/delete");
    }

    @PostMapping("delete/{orderId}")
    public ModelAndView deleteAction(@PathVariable String orderId){
        this.prophylacticOrderService.deleteProphylactic(orderId);
        return this.redirect("/orders/prophylactics/all?page=0");
    }
}
