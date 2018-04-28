package com.ispectrum.crmclima.areas.clients.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.error_handling.exception.ClientNotAddedException;
import com.ispectrum.crmclima.areas.error_handling.exception.ClientNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientController extends BaseController{
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ModelAndView allClients(@PageableDefault(size = 12) Pageable pageable){
        Page<ClientDto> allClients = this.clientService.getAllClients(pageable);
        this.addViewAndObject("objects",allClients,"clients/all");
        return this.addObject("area","clients");
    }

    @GetMapping("/details/{id}")
    public ModelAndView clientDetails(@PathVariable String id){
        ClientDto clientDto = this.clientService.getClientById(id);
        return this.addViewAndObject("client",clientDto,"clients/details/details");
    }

    @GetMapping("/add")
    public ModelAndView addClient(){
        return this.setView("clients/add");
    }

    @PostMapping("/add")
    public ModelAndView addClientAction(AddClientModel model){
        this.clientService.addClient(model);
        return this.redirect("/clients/all?page=0");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editModel(@PathVariable String id){
        ClientDto client = this.clientService.getClientById(id);
        return this.addViewAndObject("client",client,"clients/edit");
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editClientAction(@PathVariable String id, AddClientModel model){
        this.clientService.editClient(id, model);
        return this.redirect("/clients/details/"+id);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteClient(@PathVariable String id){
        ClientDto client = this.clientService.getClientById(id);
        return this.addViewAndObject("client",client,"clients/delete");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteClientAction(@PathVariable String id){
        this.clientService.deleteClient(id);
        return this.redirect("/clients/all?page=0");
    }
}
