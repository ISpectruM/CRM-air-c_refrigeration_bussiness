package com.ispectrum.crmclima.areas.clients.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/clients")
public class ClientController extends BaseController{
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ModelAndView allClients(){
        Set<ClientDto> allClients = this.clientService.getAllClients();
        return this.addViewAndObject("clients",allClients,"clients/all");
    }

    @GetMapping("/details/{id}")
    public ModelAndView clientDetails(@PathVariable String id){
        ClientDto clientDto = this.clientService.getClientById(id);
        return this.addViewAndObject("client",clientDto,"clients/details");
    }

    @GetMapping("/add")
    public ModelAndView addClient(){
        return this.view("clients/add");
    }

}
