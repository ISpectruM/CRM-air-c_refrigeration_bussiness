package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
    public void addMontage(String clientId,MontageOrderBindingModel model) {
        MontageOrder newOrder = this.mapper.map(model, MontageOrder.class);

        newOrder.setOrderDate(dateToLocaldate(model.getOrderDate()));

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(dateToLocaldate(model.getScheduleDate()));
        }

        newOrder.setClient(getClient(clientId));
        newOrder.setLocation(getLocation(model));

        addProductToOrder(newOrder, model);

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

    private LocalDate dateToLocaldate(Date date) {
        return date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
    }

    private void addProductToOrder(MontageOrder newOrder, MontageOrderBindingModel model) {
        if(model.getProductType().equals("AIRCONDS")){
            Map<AirConditioner, Integer> airConditioners = new HashMap<>();
            AirConditioner airc = this.airConditionService.getByModel(model.getProduct());
            airConditioners.put(airc,1);
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

    @Override
    public MontageOrderDto getMontageById(String id) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        return this.mapper.map(montage,MontageOrderDto.class);
    }

    @Override
    public void deleteOrder(String id) {
        MontageOrder order = this.montageOrderRepository.findFirstById(id);
        this.montageOrderRepository.delete(order);
    }

    @Override
    public void editMontage(String id, MontageOrderBindingModel model) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);

        LocalDate orderDate = dateToLocaldate(model.getOrderDate());
        if(!montage.getOrderDate().equals(orderDate)){
            montage.setOrderDate(orderDate);
        }

        LocalDate scheduleDate = dateToLocaldate(model.getScheduleDate());
        if (!montage.getScheduleDate().equals(scheduleDate)){
            montage.setScheduleDate(scheduleDate);
        }

        if (!montage.getLocation().getAddress().equals(model.getAddress())){
            Location location = getLocation(model);
            montage.setLocation(location);
        }

        if(!montage.getAirConditioners().isEmpty()){
            montage.getAirConditioners().clear();
        }
        addProductToOrder(montage, model);

        this.montageOrderRepository.saveAndFlush(montage);

    }

    @Override
    public Set<MontageOrderDto> getAllUnfinishedOrders() {
        Set<MontageOrder> allUnFinished = this.montageOrderRepository.findAllByIsFinished(false);
        Type setType = new TypeToken<Set<MontageOrderDto>>(){}.getType();
        Set<MontageOrderDto> dtos = this.mapper.map(allUnFinished, setType);
        return dtos;
    }

}
