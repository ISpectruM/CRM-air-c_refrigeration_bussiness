package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.MontageViewModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.entities.BaseProduct;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class MontageOrderServiceImpl implements MontageOrderService {
    private final ClientService clientService;
    private final AirConditionService airConditionService;
    private final ModelMapper mapper;
    private final MontageOrderRepository montageOrderRepository;


    @Autowired
    public MontageOrderServiceImpl(ClientService clientService, AirConditionService airConditionService, ModelMapper mapper, MontageOrderRepository montageOrderRepository) {
        this.clientService = clientService;
        this.airConditionService = airConditionService;
        this.mapper = mapper;
        this.montageOrderRepository = montageOrderRepository;
    }

    @Override
    public MontageViewModel getViewModel(String clientId) {
        ClientDto clientById = this.clientService.getClientById(clientId);
        MontageViewModel viewModel = new MontageViewModel();
        viewModel.setClient(clientById);
        return viewModel;
    }

    @Override
    public void addMontage(String clientId,MontageOrderBindingModel model) {
        MontageOrder newOrder = this.mapper.map(model, MontageOrder.class);

        newOrder.setOrderDate(getDate(model.getOrderDate()));

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(getDate(model.getScheduleDate()));
        }

        newOrder.setClient(getClient(clientId));
        newOrder.setLocation(getLocation(model));

        addProduct(newOrder, model);

        this.montageOrderRepository.saveAndFlush(newOrder);
    }

    private Location getLocation(MontageOrderBindingModel model) {
        Location location = new Location();
        location.setCity(model.getCity());
        location.setAddress(model.getAddress());
        return location;
    }

    private Client getClient(String clientId) {
        return this.clientService.getPureClientById(clientId);
    }

    private LocalDate getDate(Date date) {
        return date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
    }

    private void addProduct(MontageOrder newOrder, MontageOrderBindingModel model) {
        if(model.getProductType().equals("AIRCONDS")){
            Set<AirConditioner> airConditioners = new HashSet<>();
            AirConditioner airc = this.airConditionService.getByModel(model.getProduct());
            airConditioners.add(airc);
            newOrder.setAirConditioners(airConditioners);
        }
//        TODO: Add other equipment
    }

    @Override
    public Set<MontageOrderDto> getAllMontages() {
        Set<MontageOrder> montages = this.montageOrderRepository.findAllBy();
        Type setType = new TypeToken<Set<MontageOrderDto>>(){}.getType();
        return this.mapper.map(montages,setType);
    }
}
