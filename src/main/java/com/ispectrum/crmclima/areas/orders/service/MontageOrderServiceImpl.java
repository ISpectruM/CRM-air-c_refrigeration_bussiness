package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class MontageOrderServiceImpl implements MontageOrderService {
    private final ClientService clientService;
    private final AirConditionService airConditionService;
    private final MontageOrderRepository montageOrderRepository;


    @Autowired
    public MontageOrderServiceImpl(
            ClientService clientService,
            AirConditionService airConditionService,
            MontageOrderRepository montageOrderRepository) {
        this.clientService = clientService;
        this.airConditionService = airConditionService;
        this.montageOrderRepository = montageOrderRepository;
    }

    @Override
    public void addMontage(String clientId,MontageOrderBindingModel model) {
        MontageOrder newOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);

        Date orderDate = model.getOrderDate();
        LocalDate localDate = LocalDate.now();
        if (orderDate != null){
            localDate = dateToLocaldate(orderDate);
        }
        newOrder.setOrderDate(localDate);

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(dateToLocaldate(model.getScheduleDate()));
        }

        newOrder.setClient(getClient(clientId));
        newOrder.setLocation(getLocation(model));

        addProductToOrder(newOrder, model);

        this.montageOrderRepository.save(newOrder);
    }

    @Override
    public List<MontageOrderDto> getAllMontages() {
        List<MontageOrder> montages = this.montageOrderRepository.findAllByOrderByOrderDateAsc();
        return ModelMappingUtil.convertList(montages,MontageOrderDto.class);
    }

    @Override
    public MontageOrderDto getMontageById(String id) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        return ModelMappingUtil.convertClass(montage,MontageOrderDto.class);
    }

    @Override
    public void deleteOrder(String id) {
        MontageOrder order = this.montageOrderRepository.findFirstById(id);
        this.montageOrderRepository.delete(order);
    }

    @Override
    public void editMontage(String id, MontageOrderBindingModel model) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        MontageOrder editedOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);
        editedOrder.setId(id);

        Client client = montage.getClient();
        editedOrder.setClient(client);


        LocalDate orderDate = dateToLocaldate(model.getOrderDate());
        editedOrder.setOrderDate(orderDate);

        LocalDate scheduleDate = dateToLocaldate(model.getScheduleDate());
        editedOrder.setScheduleDate(scheduleDate);

        Location location = getLocation(model);
        editedOrder.setLocation(location);

        addProductToOrder(editedOrder, model);
        this.montageOrderRepository.save(editedOrder);
    }

    @Override
    public Set<MontageOrderDto> getAllUnfinishedOrders() {
        Set<MontageOrder> allUnFinished = this.montageOrderRepository.findAllByIsFinished(false);
        Set<MontageOrderDto> montageOrderDtos = ModelMappingUtil.convertSet(allUnFinished, MontageOrderDto.class);
        return montageOrderDtos;
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
            airConditioners.put(airc,model.getCount());
            newOrder.setAirConditioners(airConditioners);
        }
//        TODO: Add other equipment
    }

    private Location getLocation(MontageOrderBindingModel model) {
        Location location = new Location();
        location.setCity(model.getCity());
        location.setAddress(model.getAddress());
        return location;
    }



}
