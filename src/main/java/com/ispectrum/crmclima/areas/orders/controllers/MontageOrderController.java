package com.ispectrum.crmclima.areas.orders.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class MontageOrderController extends BaseController{
    private final MontageOrderService montageOrderService;
    private final ClientService clientService;

    @Autowired
    public MontageOrderController(MontageOrderService montageOrderService, ClientService clientService) {
        this.montageOrderService = montageOrderService;
        this.clientService = clientService;
    }

    @GetMapping("/montages/add/{clientId}")
    public ModelAndView addOrder(@PathVariable String clientId){
        ClientDto client = this.clientService.getClientById(clientId);
        return this.addViewAndObject("client",client,"orders/add_montage");
    }
}
