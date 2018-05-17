package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.error_handling.exception.MontageNotFoundException;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.MontageOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseBindingModel;
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

        MontageOrder newOrder = createNewOrder(clientId, model);

        Map<AirConditioner, Integer> airConditioners = getAirConditionersFromInput(model.getAircProductsBin());
        newOrder.setAirConditioners(airConditioners);

        this.montageOrderRepository.save(newOrder);
    }

    @Override
    public boolean addOfferView(String clientId, OfferViewBindingModel model) {
        MontageOrder newOrder = this.createNewOrder(clientId,model);
        this.montageOrderRepository.save(newOrder);
        return false;
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

    @Override
    public boolean deleteOrder(String id) {
        MontageOrder montageToDelete = this.montageOrderRepository.findFirstById(id);
        if(montageToDelete == null){
            throw new MontageNotFoundException();
        }
        try {
            montageToDelete.setDeletedOn(LocalDate.now());
            this.montageOrderRepository.save(montageToDelete);

        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void editMontage(String id, MontageOrderBindingModel model) {
        MontageOrder montage = this.montageOrderRepository.findFirstById(id);
        if (montage == null){
            throw new MontageNotFoundException();
        }
        MontageOrder editedOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);
        editedOrder.setId(id);

        if (editedOrder.getIsFinished()){
            editedOrder.setEndDate(LocalDate.now());
        }

        Client client = montage.getClient();
        editedOrder.setClient(client);

        LocalDate orderDate = DateToLocalDate.convert(model.getOrderDate());
        editedOrder.setOrderDate(orderDate);

        Date modelScheduleDate = model.getScheduleDate();
        LocalDate newScheduleDate=null;
        if (modelScheduleDate != null){
            newScheduleDate=DateToLocalDate.convert(model.getScheduleDate());
        }
        editedOrder.setScheduleDate(newScheduleDate);

        Location location = createLocation(model);
        editedOrder.setLocation(location);

        List<String> aircProductsBin = model.getAircProductsBin();
        Map<AirConditioner, Integer> airconditioners = getAirConditionersFromInput(aircProductsBin);
        editedOrder.setAirConditioners(airconditioners);
        this.montageOrderRepository.save(editedOrder);
    }

    @Override
    public List<MontageOrderDto> getAllUnfinishedMontagesDtos() {
        List<MontageOrder> allUnFinished =
                this.montageOrderRepository.findAllByIsFinishedAndDeletedOnIsNull(false);
        return ModelMappingUtil.convertList(allUnFinished, MontageOrderDto.class);
    }

    @Override
    public List<MontageOrder> getAllUnfinishedMontages() {
        return this.montageOrderRepository.findAllByIsFinishedAndDeletedOnIsNull(false);
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
    public Set<MontageOrder> getMontagesByDateNotFinished(LocalDate scheduleDate) {
        return this.montageOrderRepository.findAllByScheduleDateAndIsFinished(scheduleDate,false);
    }

    private Client createClient(String clientId) {
        return this.clientService.getPureClientById(clientId);
    }

    private Map<AirConditioner, Integer> getAirConditionersFromInput(List<String> aircProductsBin) {
        Map<AirConditioner, Integer> airConditioners = new HashMap<>();

        for (String product : aircProductsBin) {
            String[] tokens = product.split(" - ");
            String aircModel = tokens[1];
            int count = Integer.parseInt(tokens[2]);
            AirConditioner airc = this.airConditionService.getByModel(aircModel);
            airConditioners.put(airc, count);
        }
        return airConditioners;
    }

//    private void addProductToOrder(MontageOrder newOrder, OfferViewBindingModel model) {
//        String orderType = model.getMontageType();
//        if(orderType.equals("OVERVIEW")){
////            TODO
//        } else if(orderType.equals("OFFER")){
////TODO
//        }
//    }

    private Location createLocation(BaseBindingModel model) {
        Location location = new Location();
        location.setCity(model.getCity());
        location.setAddress(model.getAddress());
        return location;
    }

    private <T extends BaseBindingModel> MontageOrder createNewOrder(String clientId, T  model) {
        MontageOrder newOrder = ModelMappingUtil.convertClass(model, MontageOrder.class);

        Long orderNumber = this.montageOrderRepository
                .findTopByOrderByOrderNumberDesc().getOrderNumber();
        if (orderNumber == null){
            orderNumber=0L;
        }
        newOrder.setOrderNumber(orderNumber+1);

        Date orderDate = model.getOrderDate();
        LocalDate localDate = LocalDate.now();
        if (orderDate != null){
            localDate = DateToLocalDate.convert(orderDate);
        }
        newOrder.setOrderDate(localDate);

        if (model.getScheduleDate() != null){
            newOrder.setScheduleDate(DateToLocalDate.convert(model.getScheduleDate()));
        }

        newOrder.setClient(createClient(clientId));
        newOrder.setLocation(createLocation(model));

        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = this.userDetailsService.loadUserByUsername(principal.getName());
        newOrder.setUser((User)user);
        return newOrder;
    }

}
