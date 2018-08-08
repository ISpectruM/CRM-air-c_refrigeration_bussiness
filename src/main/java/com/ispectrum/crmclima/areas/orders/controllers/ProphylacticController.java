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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

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
            @PageableDefault(sort = {"orderNumber"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<ProphylacticOrderDto> prophylactics =
                this.prophylacticOrderService.getAllProphylactics(pageable);
        this.addViewAndObject("objects", prophylactics, "orders/prophylactics/all");
        return this.addObject("area", "orders/prophylactics");

    }

    @GetMapping("/add/{clientId}")
    public ModelAndView addProphylactic(@PathVariable String clientId){
        ClientDto clientDto = this.clientService.getClientById(clientId);

        this.setView("orders/prophylactics/add");
        this.addObject("client", clientDto);
        this.addObject("currentDate", LocalDate.now());
        return this.addObject("bindingModel", new ProphylacticBindingModel());
    }


}
