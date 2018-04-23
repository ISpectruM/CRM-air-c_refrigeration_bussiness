package com.ispectrum.crmclima.areas.search;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.repository.ClientRepository;
import com.ispectrum.crmclima.areas.search.models.SearchBindingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchServiceImpl implements SearchService {

    private final ClientRepository clientRepository;

    @Autowired
    public SearchServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Set<ClientDto> getClientByPhone(String phone) {
        Set<Client> clients = this.clientRepository.findClientsByPhoneContaining(phone);
        return ModelMappingUtil.convertSet(clients,ClientDto.class);
    }

    @Override
    public Set<ClientDto> getClientsByAddress(String address) {
        Set<Client> clients = this.clientRepository.findClientsByAddressContaining(address);
        return ModelMappingUtil.convertSet(clients,ClientDto.class);
    }

    @Override
    public Set<ClientDto> getClientsByName(String name) {
        Set<Client> clients = this.clientRepository.findClientsByNameContaining(name);
        return ModelMappingUtil.convertSet(clients,ClientDto.class);
    }

    @Override
    public Set<ClientDto> getSearchResults(SearchBindingModel model) {
        String criteria = model.getCriteria();
        switch (criteria) {
            case "isAddressSearch":
                return this.getClientsByAddress(model.getSearchString());
            case "isNameSearch":
                return this.getClientsByName(model.getSearchString());
            case "isPhoneSearch":
                return this.getClientByPhone(model.getSearchString());
        }
        return null;
    }
}
