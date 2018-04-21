package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/orders/montages")
public class MontageOrderController extends BaseController{
    private final MontageOrderService montageOrderService;
    private final ClientService clientService;

    @Autowired
    public MontageOrderController(MontageOrderService montageOrderService, ClientService clientService) {
        this.montageOrderService = montageOrderService;
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ModelAndView getAllMontages(){
        Set<MontageOrderDto> allMontages = this.montageOrderService.getAllMontages();
        return this.addViewAndObject("montages",allMontages,"orders/montages/all");
    }

    @GetMapping("/add/{clientId}")
    public ModelAndView addOrder(@PathVariable String clientId){
        ClientDto client = this.clientService.getClientById(clientId);
        return this.addViewAndObject("client",client,"orders/montages/add_montage");
    }


    @PostMapping("/add/{id}")
    public ModelAndView addOrderAction(@PathVariable String id,
            MontageOrderBindingModel model){
        this.montageOrderService.addMontage(id, model);
        return this.redirect("/orders/montages/all");
    }

    @GetMapping("/details/{id}")
    public ModelAndView getMontageDetails(@PathVariable String id){
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);
        return this.addViewAndObject("montage",montage,"orders/montages/details");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editOrder(@PathVariable String id){
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);
        return this.addViewAndObject("montage", montage,"orders/montages/edit");
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editOrderAction(@PathVariable String id,
                                        MontageOrderBindingModel model){
        this.montageOrderService.editMontage(id,model);
        return this.redirect("/orders/montages/details/" + id);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteOrder(@PathVariable String id){
        MontageOrderDto montage = this.montageOrderService.getMontageById(id);
        return this.addViewAndObject("montage", montage,"orders/montages/delete");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteOrderAction(@PathVariable String id){
        this.montageOrderService.deleteOrder(id);
        return this.redirect("/orders/montages/all");
    }


}
