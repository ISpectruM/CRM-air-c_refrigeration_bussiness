package com.ispectrum.crmclima.areas.clients.service;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.bindingModels.AddClientModel;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addClient(AddClientModel model) {
        Client client = this.modelMapper.map(model, Client.class);
        this.clientRepository.saveAndFlush(client);
    }

    @Override
    public Set<ClientDto> getAllClients() {
        Set<Client> clients = this.clientRepository.findAllBy();
        Type setDtoType = new TypeToken<Set<ClientDto>>(){}.getType();
        return this.modelMapper.map(clients,setDtoType);
    }

    @Override
    public ClientDto getClientById(String id) {
//        TODO Error handling if not found
        Client client = this.clientRepository.findFirstById(id);
        return this.modelMapper.map(client,ClientDto.class);
    }

    @Override
    public void editClient(String id, AddClientModel model) {
        Client client = this.modelMapper.map(model, Client.class);
        client.setId(id);
        this.clientRepository.saveAndFlush(client);
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

}
