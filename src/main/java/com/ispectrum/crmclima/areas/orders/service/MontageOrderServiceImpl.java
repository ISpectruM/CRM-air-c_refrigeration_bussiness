package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.models.MontageViewModel;
import javassist.expr.Instanceof;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class MontageOrderServiceImpl implements MontageOrderService {
    private final ClientService clientService;
    private final ModelMapper mapper;

    @Autowired
    public MontageOrderServiceImpl(ClientService clientService, ModelMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @Override
    public MontageViewModel getViewModel(String clientId) {
        ClientDto clientById = this.clientService.getClientById(clientId);
        MontageViewModel viewModel = new MontageViewModel();
        viewModel.setClient(clientById);
        return viewModel;
    }
}
