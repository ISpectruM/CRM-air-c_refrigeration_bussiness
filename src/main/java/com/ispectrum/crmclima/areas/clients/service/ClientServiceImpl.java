package com.ispectrum.crmclima.areas.clients.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import com.ispectrum.crmclima.areas.error_handling.exception.ClientNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client addClient(AddClientModel model) {
        Client client = ModelMappingUtil.convertClass(model,Client.class);
       return this.clientRepository.save(client);
    }

    @Override
    public Page<ClientDto> getAllClients(Pageable pageable) {
        Page<Client> clients = this.clientRepository.findAllByOrderByEnterDateDesc(pageable);
        return ModelMappingUtil.convertPage(clients,ClientDto.class);
    }

    @Override
    public ClientDto getClientById(String id) {
        Client client = this.clientRepository.findFirstById(id);
        if (client == null){
            throw new ClientNotFoundException();
        }
        return ModelMappingUtil.convertClass(client,ClientDto.class);
    }

    @Override
    public Client editClient(String id, AddClientModel model) {
        Client client = this.clientRepository.findFirstById(id);
        if (client == null){
            throw new ClientNotFoundException();
        }
        client.setAddress(model.getAddress());
        client.setCity(model.getCity());
        client.setEmail(model.getEmail());
        client.setPhone(model.getPhone());
        client.setName(model.getName());
        return this.clientRepository.save(client);
    }

    @Override
    public void deleteClient(String id) {
        Client client = this.clientRepository.findFirstById(id);
        if (client == null){
            throw new ClientNotFoundException();
        }
        this.clientRepository.delete(client);
    }

    @Override
    public Client getPureClientById(String id) {
        Client client = this.clientRepository.findFirstById(id);
        if (client == null){
            throw new ClientNotFoundException();
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAllBy();
    }
  }
