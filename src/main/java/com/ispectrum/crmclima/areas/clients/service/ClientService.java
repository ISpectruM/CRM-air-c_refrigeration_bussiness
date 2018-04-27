package com.ispectrum.crmclima.areas.clients.service;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface ClientService {
    Client addClient(AddClientModel model);

    Page<ClientDto> getAllClients(Pageable pageable);

    ClientDto getClientById(String id);

    Client editClient(String id, AddClientModel model);

    void deleteClient(String id);

    Client getPureClientById(String id);

    List<Client> getAllClients();
}
