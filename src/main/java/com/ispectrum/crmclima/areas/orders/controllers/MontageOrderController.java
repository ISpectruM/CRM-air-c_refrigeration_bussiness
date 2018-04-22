package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
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
        List<MontageOrderDto> allMontages = this.montageOrderService.getAllMontages();
        return this.addViewAndObject("montages",allMontages,"orders/montages/all");
    }

    @GetMapping("/add/{clientId}")
    public ModelAndView addOrder(@PathVariable String clientId){
        this.setView("orders/montages/add_montage");
        ClientDto client = this.clientService.getClientById(clientId);
        this.addObject("bindingModel",new MontageOrderBindingModel());
        return this.addObject("client",client);
    }


    @PostMapping("/add/{id}")
    public ModelAndView addOrderAction(
            @PathVariable String id,
            @Valid @ModelAttribute(name = "bindingModel") MontageOrderBindingModel bindingModel,
            BindingResult bindingResult){

            if (bindingResult.hasErrors()){
                Map<String, Object> model = bindingResult.getModel();
                ClientDto client = this.clientService.getClientById(id);
                model.put("client",client);
                return this.addViewAndObjectsMap("orders/montages/add_montage",model);
            }
        this.montageOrderService.addMontage(id, bindingModel);
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
