package com.ispectrum.crmclima.areas.search;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.search.models.SearchBindingModel;

import java.util.Set;

public interface SearchService {
    Set<ClientDto> getClientByPhone(String phone);

    Set<ClientDto> getClientsByAddress(String address);

    Set<ClientDto> getClientsByName(String name);

    Set<ClientDto> getSearchResults(SearchBindingModel model);
}
