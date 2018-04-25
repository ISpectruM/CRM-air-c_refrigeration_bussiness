package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.OrderSaveModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
            localDate = dateToLocaleDate(orderDate);
        }
        newOrder.setOrderDate(localDate);

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(dateToLocaleDate(model.getScheduleDate()));
        }

        newOrder.setClient(getClient(clientId));
        newOrder.setLocation(getLocation(model));

        addProductToOrder(newOrder, model);

        this.montageOrderRepository.save(newOrder);
    }

    @Override
    public Page<MontageOrderDto> getAllMontages(Pageable pageable) {
        Page<MontageOrder> montages = this.montageOrderRepository.findAll(pageable);
        return ModelMappingUtil.convertPage(montages,MontageOrderDto.class);
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


        LocalDate orderDate = dateToLocaleDate(model.getOrderDate());
        editedOrder.setOrderDate(orderDate);

        LocalDate scheduleDate = dateToLocaleDate(model.getScheduleDate());
        editedOrder.setScheduleDate(scheduleDate);

        Location location = getLocation(model);
        editedOrder.setLocation(location);

        addProductToOrder(editedOrder, model);
        this.montageOrderRepository.save(editedOrder);
    }

    @Override
    public List<MontageOrderDto> getAllUnfinishedMontagesDtos() {
        List<MontageOrder> allUnFinished = this.montageOrderRepository.findAllByIsFinished(false);
        return ModelMappingUtil.convertList(allUnFinished, MontageOrderDto.class);
    }

    @Override
    public List<MontageOrder> getAllUnfinishedMontages() {
        return this.montageOrderRepository.findAllByIsFinished(false);
    }

    @Override
    public void saveMontageChanges(OrderSaveModel model) {
        String id = model.getId();
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
//        Set new status
        montage.setIsDeferred(model.getStatus().getIsDeferred());
        montage.setIsFinished(model.getStatus().getIsFinished());
        montage.setIsForFinishing(model.getStatus().getIsForFinishing());
        montage.setIsMarked(model.getStatus().getIsMarked());
        montage.setIsPayed(model.getStatus().getIsPayed());
        montage.setIsWaiting(model.getStatus().getIsWaiting());
        montage.setIsWithInvoice(model.getStatus().getIsWithInvoice());

        if (montage.getIsFinished()){
            montage.setEndDate(LocalDate.now());
        }

        //        set new schedule date
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern(
                "yyyy-MM-dd", Locale.getDefault());
        LocalDate date = LocalDate.parse(model.getScheduleDate(), formatter);
        montage.setScheduleDate(date);

        this.montageOrderRepository.save(montage);
    }


    private Client getClient(String clientId) {
        return this.clientService.getPureClientById(clientId);
    }

    private LocalDate dateToLocaleDate(Date date) {
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
