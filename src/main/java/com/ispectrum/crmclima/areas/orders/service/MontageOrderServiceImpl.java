package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.error_handling.exception.MontageNotFoundException;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.EditMontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.OfferViewBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.montage_models.MontageOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.repository.MontageOrderRepository;
import com.ispectrum.crmclima.areas.products.entities.AirConditioner;
import com.ispectrum.crmclima.areas.products.service.AirConditionService;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

@Service
public class MontageOrderServiceImpl implements MontageOrderService {
    private final ClientService clientService;
    private final AirConditionService airConditionService;
    private final MontageOrderRepository montageOrderRepository;
    private final UserServiceImpl userDetailsService;


    @Autowired
    public MontageOrderServiceImpl(
            ClientService clientService,
            AirConditionService airConditionService,
            MontageOrderRepository montageOrderRepository, UserServiceImpl userDetailsService) {
        this.clientService = clientService;
        this.airConditionService = airConditionService;
        this.montageOrderRepository = montageOrderRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void addMontage(String clientId, MontageOrderBindingModel model) {

        MontageOrder newOrder = this.createNewOrder(clientId, model);

        Map<AirConditioner, Integer> airConditioners = this.getAirConditionersFromInput(model.getAircProductsBin());
        newOrder.setAirConditioners(airConditioners);

        this.montageOrderRepository.save(newOrder);
    }

    @Override
    public void editMontage(String id, EditMontageOrderBindingModel model) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        if (montage == null){
            throw new MontageNotFoundException();
        }
//        Map dto to model
        MontageOrder editedOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);

        editedOrder.setId(id);
        editedOrder.setOrderNumber(montage.getOrderNumber());

//  Check is isFinished and assign finish date
        if (editedOrder.getIsFinished()){
            editedOrder.setEndDate(LocalDate.now());
        }
//  Set client
        editedOrder.setClient(montage.getClient());
//  Set orderDate
        editedOrder.setOrderDate(DateToLocalDate.setLocalDate(model));

//  Set scheduleDate if present
        Date modelScheduleDate = model.getScheduleDate();
        if (modelScheduleDate != null){
            editedOrder.setScheduleDate(DateToLocalDate.convert(modelScheduleDate));
        }

//  Set location
        editedOrder.setLocation(createLocation(model));

//Set new products if present
        List<String> aircProductsBin = model.getAircProductsBin();
        if (model.getIsAircProductChanged()){
            Map<AirConditioner, Integer> airconditioners = getAirConditionersFromInput(aircProductsBin);
            editedOrder.setAirConditioners(airconditioners);
        } else {
            editedOrder.setAirConditioners(montage.getAirConditioners());
        }

        this.montageOrderRepository.save(editedOrder);
    }

    @Override
    public boolean addOfferView(String clientId, OfferViewBindingModel model) {
        MontageOrder newOrder = this.createNewOrder(clientId,model);
        this.montageOrderRepository.save(newOrder);
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        MontageOrder montageToDelete = this.montageOrderRepository.findFirstById(id);

        try {
            if(montageToDelete == null){
                throw new MontageNotFoundException();
            }
            montageToDelete.setDeletedOn(LocalDate.now());
            this.montageOrderRepository.save(montageToDelete);

        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void saveScheduleMontageChanges(RestOrderBindingModel model) {
        String id = model.getId();
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        if (montage == null){
            throw new MontageNotFoundException();
        }
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

        LocalDate date = DateToLocalDate.convert(model.getScheduleDate());
        montage.setScheduleDate(date);

        this.montageOrderRepository.save(montage);
    }

    @Override
    public Page<MontageOrderDto> getAllMontages(Pageable pageable) {
        Page<MontageOrder> montages = this.montageOrderRepository.findAllByDeletedOnIsNull(pageable);
        return ModelMappingUtil.convertPage(montages,MontageOrderDto.class);
    }

    @Override
    public MontageOrderDto getMontageById(String id) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        if(montage == null){
            throw new MontageNotFoundException();
        }
        return ModelMappingUtil.convertClass(montage,MontageOrderDto.class);
    }
    //Used to generate daily schedule including active and unfinished orders only

    @Override
    public List<MontageOrderDto> getAllUnfinishedMontagesDtos() {
        List<MontageOrder> allUnFinished =
                this.montageOrderRepository.findAllByIsFinishedAndDeletedOnIsNull(false);
        return ModelMappingUtil.convertList(allUnFinished, MontageOrderDto.class);
    }
    //Used by the orders interceptor service to show the count of all unfinished active montages

    @Override
    public List<MontageOrder> getAllUnfinishedMontages() {
        return this.montageOrderRepository.findAllByIsFinishedAndDeletedOnIsNull(false);
    }

//    Used to deliver scheduled montages by date
    @Override
    public Set<MontageOrder> getMontagesByDateNotFinished(LocalDate scheduleDate) {
        return this.montageOrderRepository.findAllByScheduleDateAndIsFinished(scheduleDate,false);
    }

    private Client createClient(String clientId) {
        return this.clientService.getPureClientById(clientId);
    }

    private Map<AirConditioner, Integer> getAirConditionersFromInput(List<String> aircProductsBin) {
        Map<AirConditioner,Integer> airconditioners = new HashMap<>();

        for (String product : aircProductsBin) {
            String[] tokens = product.split(" - ");
            String aircModel = tokens[1];
            int count = Integer.parseInt(tokens[2]);
            AirConditioner airc = this.airConditionService.getByModel(aircModel);
            if (airconditioners.containsKey(airc)){
                Integer available = airconditioners.get(airc);
                airconditioners.put(airc,available + count);
            }else {
                airconditioners.put(airc,count);
            }
        }
        return airconditioners;
    }

    private Location createLocation(BaseOrderBindingModel model) {
        Location location = new Location();
        location.setCity(model.getCity());
        location.setAddress(model.getAddress());
        return location;
    }

    private <T extends BaseOrderBindingModel> MontageOrder createNewOrder(String clientId, T  model) {
        MontageOrder newOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);

        MontageOrder lastOrder = this.montageOrderRepository
                .findTopByOrderByOrderNumberDesc();
        Long orderNumber = 0L;
        if (lastOrder != null){
            orderNumber = lastOrder.getOrderNumber();
        }

        newOrder.setOrderNumber(orderNumber + 1);
        newOrder.setOrderDate(DateToLocalDate.setLocalDate(model));

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(DateToLocalDate.convert(model.getScheduleDate()));
        }

        newOrder.setClient(createClient(clientId));
        newOrder.setLocation(createLocation(model));
        newOrder.setUser((User)getCurrentUser());

        return newOrder;
    }

    private UserDetails getCurrentUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return this.userDetailsService.loadUserByUsername(principal.getName());
    }


}
