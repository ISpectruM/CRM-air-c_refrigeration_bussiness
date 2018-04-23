package com.ispectrum.crmclima.areas.clients.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void addClient(AddClientModel model) {
        Client client = ModelMappingUtil.convertClass(model,Client.class);
        this.clientRepository.save(client);
    }

    @Override
    public Page<ClientDto> getAllClients(Pageable pageable) {
        Page<Client> clients = this.clientRepository.findAll(pageable);
        return ModelMappingUtil.convertPage(clients,ClientDto.class);
    }

    @Override
    public ClientDto getClientById(String id) {
//        TODO Error handling if not found
        Client client = this.clientRepository.findFirstById(id);
        return ModelMappingUtil.convertClass(client,ClientDto.class);
    }

    @Override
    public void editClient(String id, AddClientModel model) {
        Client client = ModelMappingUtil.convertClass(model, Client.class);
        client.setId(id);
        this.clientRepository.save(client);
    }

    @Override
    public void deleteClient(String id) {
        Client client = this.clientRepository.findFirstById(id);
        this.clientRepository.delete(client);
    }

    @Override
    public Client getPureClientById(String id) {
        return this.clientRepository.findFirstById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAllBy();
    }

}
