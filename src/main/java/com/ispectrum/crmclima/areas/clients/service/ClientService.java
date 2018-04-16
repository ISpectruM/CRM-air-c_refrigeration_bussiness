package com.ispectrum.crmclima.areas.clients.service;

import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;

import java.util.Set;

public interface ClientService {
    void addClient(AddClientModel model);

    Set<ClientDto> getAllClients();

    ClientDto getClientById(String id);
}
