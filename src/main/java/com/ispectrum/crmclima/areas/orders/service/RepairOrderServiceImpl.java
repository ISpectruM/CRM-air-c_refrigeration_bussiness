package com.ispectrum.crmclima.areas.orders.service;

import com.ispectrum.crmclima.Utils.DateToLocalDate;
import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.clients.entities.Client;
import com.ispectrum.crmclima.areas.clients.service.ClientService;
import com.ispectrum.crmclima.areas.error_handling.exception.ClientNotFoundException;
import com.ispectrum.crmclima.areas.error_handling.exception.MontageNotFoundException;
import com.ispectrum.crmclima.areas.error_handling.exception.RepairNotFoundException;
import com.ispectrum.crmclima.areas.locations.entities.Location;
import com.ispectrum.crmclima.areas.orders.entities.RepairOrder;
import com.ispectrum.crmclima.areas.orders.models.ajax.RestOrderBindingModel;
import com.ispectrum.crmclima.areas.orders.models.bindingModels.repair_models.RepairBindingModel;
import com.ispectrum.crmclima.areas.orders.models.dtos.RepairOrderDto;
import com.ispectrum.crmclima.areas.orders.repository.RepairOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;
    private final ClientService clientService;

    @Autowired
    public RepairOrderServiceImpl(RepairOrderRepository repairOrderRepository, ClientService clientService) {
        this.repairOrderRepository = repairOrderRepository;
        this.clientService = clientService;
    }

    @Override
    public RepairOrder saveRepairOrder(String clientId, RepairBindingModel model) {
        //Map binding data to new order
        RepairOrder newOrder = ModelMappingUtil.convertClass(model, RepairOrder.class);

        // Set order number
        RepairOrder lastOrder = this.repairOrderRepository
                .findTopByOrderByOrderNumberDesc();
        Long orderNumber = 0L;
        if (lastOrder != null){
            orderNumber=lastOrder.getOrderNumber();
        }
        newOrder.setOrderNumber(orderNumber+1);

        // Set order date
        newOrder.setOrderDate(DateToLocalDate.setLocalDate(model));

        // Set client
        Client pureClientById = this.clientService.getPureClientById(clientId);
        if(pureClientById == null){
            throw new ClientNotFoundException();
        }
        newOrder.setClient(pureClientById);

        //Set schedule date
        if (model.getScheduleDate() != null){
            newOrder.setEndDate(DateToLocalDate.convert(model.getScheduleDate()));
        }
        // Set order location
        Location location = ModelMappingUtil.convertClass(model,Location.class);
        newOrder.setLocation(location);

        return this.repairOrderRepository.save(newOrder);
    }

    @Override
    public RepairOrder editRepair(String id, RepairBindingModel bindingModel) {
        RepairOrder repair = this.repairOrderRepository.findFirstById(id);
        if (repair == null){
            throw new MontageNotFoundException();
        }
        RepairOrder editedOrder = ModelMappingUtil.convertClass(bindingModel, RepairOrder.class);

        editedOrder.setId(id);
        editedOrder.setClient(repair.getClient());
        editedOrder.setOrderDate(DateToLocalDate.setLocalDate(bindingModel));

        Date scheduleDate = bindingModel.getScheduleDate();
        LocalDate newDate = null;
        if (scheduleDate != null){
            newDate = DateToLocalDate.convert(scheduleDate);
        }
        editedOrder.setScheduleDate(newDate);

        Location location = this.getLocation(bindingModel);
        editedOrder.setLocation(location);

        return this.repairOrderRepository.save(editedOrder);
    }

    @Override
    public boolean deleteRepair(String id) {
        RepairOrder repairToDelete = this.repairOrderRepository.findFirstById(id);
        return this.deleteOrder(repairToDelete, this.repairOrderRepository);
    }

    //Get all active and unfinished repair orders
    @Override
    public List<RepairOrder> getUnfinishedRepairs() {
        return this.repairOrderRepository.findAllByIsFinishedIsFalseAndDeletedOnIsNull();
    }

    @Override
    public Set<RepairOrder> getRepairsByScheduleDateNotFinished(LocalDate scheduleDate) {
        return this.repairOrderRepository.findAllByScheduleDate(scheduleDate);
    }

    @Override
    public Integer getAllUnfinishedRepairsCount() {
        return this.repairOrderRepository.countByIsFinishedIsFalseAndDeletedOnIsNull();
    }

    @Override
    public Page<RepairOrderDto> getAllRepairs(Pageable pageable) {
        Page<RepairOrder> allRepairs = this.repairOrderRepository.findAllByDeletedOnIsNull(pageable);
        return ModelMappingUtil.convertPage(allRepairs,RepairOrderDto.class);
    }

    @Override
    public RepairOrderDto getRepairById(String id) {
        RepairOrder firstById = this.repairOrderRepository.findFirstById(id);
        return ModelMappingUtil.convertClass(firstById,RepairOrderDto.class);
    }

    private Location getLocation(RepairBindingModel model) {
        Location location = ModelMappingUtil.convertClass(model, Location.class);
//        location.setCity(model.getCity());
//        location.setAddress(model.getAddress());
        return location;
    }

}
